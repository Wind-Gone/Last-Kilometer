package com.example.accessingdatamongodb.Repository;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
public
class MongodbExplain {

    @Autowired
    private MongoTemplate mongoTemplate;

    public String explainQuery(Query query, String collectionName) {
        Document explainDocument = new Document();
        explainDocument.put("find", collectionName);
        explainDocument.put("filter", query.getQueryObject());

        Document command = new Document();
        command.put("explain", explainDocument);

        Document explainResult = mongoTemplate.getDb().runCommand(command);
        return explainResult.toJson();
    }

    @PostConstruct
    public void postConstrucut() {
        Query query = new Query(Criteria.where("name").is("hu"));
        String explainResult = explainQuery(query, "User");
        System.out.println(explainResult);
    }

}