package com.example.accessingdatamongodb.Util;

import com.example.accessingdatamongodb.Entity.Parcel;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.stereotype.Component;

@Component
public class CfUtil {
    private File file;

    private DataModel dataModel;
    //计算相似度，相似度算法有很多种，欧几里得、皮尔逊等等。
    private ItemSimilarity itemSimilarity;
    //构建推荐器，协同过滤推荐有两种，分别是基于用户的和基于物品的，这里使用基于物品的协同过滤推荐
    private GenericItemBasedRecommender recommender;


    //基于用户
    private UserSimilarity userSimilarity;
    private UserNeighborhood userNeighborhood;
    //构建推荐器，协同过滤推荐有两种，分别是基于用户的和基于物品的，这里使用基于用户的协同过滤推荐
    private Recommender recommender2;




    public CfUtil() throws TasteException, IOException {
        file =new File("src/main/resources/data.csv");
        dataModel = new FileDataModel(file);

        /*基于物品*/
        //计算相似度，相似度算法有很多种，欧几里得、皮尔逊等等。
        itemSimilarity = new PearsonCorrelationSimilarity(dataModel);
        //构建推荐器，协同过滤推荐有两种，分别是基于用户的和基于物品的，这里使用基于物品的协同过滤推荐
        recommender = new GenericItemBasedRecommender(dataModel, itemSimilarity);

        /* 基于用户 */
        userSimilarity= new PearsonCorrelationSimilarity(dataModel);
        userNeighborhood = new NearestNUserNeighborhood(20,userSimilarity, dataModel);
        recommender2 = new GenericUserBasedRecommender(dataModel, userNeighborhood, userSimilarity);


    }

    /*暂时让他返回ItemID的列表*/
    public List<Long> CfItemBased(int UserID,int ItemID,int HowMany) throws TasteException {
        List<RecommendedItem> recommendedItemList = recommender.recommendedBecause(UserID, ItemID, HowMany);
        List<Long> res= new LinkedList<>();
        for (RecommendedItem recommendedItem : recommendedItemList) {
            res.add(recommendedItem.getItemID());
        }
        return res;
    }

    public List<Long> CfUserBased(int UserID,int HowMany) throws TasteException {
        List<RecommendedItem> recommendedItemList = recommender.recommend(UserID, HowMany);;
        List<Long> res= new LinkedList<>();
        for (RecommendedItem recommendedItem : recommendedItemList) {
            res.add(recommendedItem.getItemID());
        }
        return res;
    }



}
