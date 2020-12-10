package com.example.accessingdatamongodb.Repository;

import com.example.accessingdatamongodb.Entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String> {

}
