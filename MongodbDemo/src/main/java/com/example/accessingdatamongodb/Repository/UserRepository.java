package com.example.accessingdatamongodb.Repository;

import java.util.List;

import com.example.accessingdatamongodb.Entity.Tag;
import com.example.accessingdatamongodb.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface UserRepository extends MongoRepository<User, String> {

    public List<User> findByName(String name);

    public User findFirstByName(String name);

//    @Query(value = "{}")
//    public List<User> updateByName(Tag tag , String name )

    @Query(value = "{'creditScore' : {$gte : ?0 } }")
    public List<User> findGoodScore(double score);
}