package com.example.accessingdatamongodb.Service;

import com.example.accessingdatamongodb.Entity.User;
import com.example.accessingdatamongodb.Repository.UserRepository;
import com.example.accessingdatamongodb.redis.RedisService;
import com.example.accessingdatamongodb.redis.UserKey;
import com.google.common.base.Preconditions;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RedisService redisService;

    public List<User> findAll() {
        return userRepository.findAll();
    }


    public void addUser(User user) {
        Preconditions.checkNotNull(user, "未输入要新增的用户实体");
        userRepository.insert(user);
    }

    public void update(User user) {
        Preconditions.checkNotNull(user, "未输入要新增的用户实体");
        String t=userRepository.findFirstByName(user.getName()).getId();
        user.setId(t);
        userRepository.save(user);
    }

    public void delete(String id) {
        Preconditions.checkNotNull(id, "未输入要删除的用户id");
        userRepository.deleteById(id);
    }

    public List<User> findByExample(User user) {
        Preconditions.checkNotNull(user, "未输入要新增的用户实体");
        user.setName("Alice");
        Example<User> e = Example.of(user);
        return userRepository.findAll(e);
    }

    public User getById(Long id) {
        Preconditions.checkNotNull(id, "未输入要查询的用户Id");
        //对象缓存
        User user = redisService.get(UserKey.getById, "" + id, User.class);
        if (user != null) {
            return user;
        }
        user = userRepository.findBystudentID(id);
        redisService.set(UserKey.getById, "" + id, user);
        return user;
    }

    public List<User> getGoodScore(double score) {
        return userRepository.findGoodScore(score);
    }

    public List<RecommendedItem> getRecommendParcel(long userId) throws IOException, TasteException {
        System.out.println("1");
        // 从文件加载数据
        DataModel model = new FileDataModel(new File("D:\\hu\\Study\\Project\\Last-Kilometer\\MongodbDemo\\src\\main\\java\\com\\example\\accessingdatamongodb\\data.csv"));
        System.out.println("2");
        // 指定用户相似度计算方法，这里采用皮尔森相关度
        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
        // 指定用户邻居数量，这里为2
        UserNeighborhood neighborhood = new NearestNUserNeighborhood(2,
                similarity, model);
        // 构建基于用户的推荐系统
        Recommender recommender = new GenericUserBasedRecommender(model,
                neighborhood, similarity);
        // 得到指定用户的推荐结果，这里是得到用户1的两个推荐
        System.out.println("3");
        List<RecommendedItem> recommendations = recommender.recommend(userId, 1);
        // 打印推荐结果
        for (RecommendedItem recommendation : recommendations) {
            System.out.println(recommendation);
        }
        return recommendations;
    }

    public List<User> getByName(String name) {
        Preconditions.checkNotNull(name, "未输入要查询的用户姓名");
        return userRepository.findByName(name);
    }

}
