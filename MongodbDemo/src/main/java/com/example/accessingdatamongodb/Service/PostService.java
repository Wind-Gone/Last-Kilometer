package com.example.accessingdatamongodb.Service;

import com.example.accessingdatamongodb.Entity.Post;
import com.example.accessingdatamongodb.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }


    public Post addOne(Post post) {
        return postRepository.insert(post);
    }

    public Post update(Post post) {
        return postRepository.save(post);
    }

    public void delete(String id) {
        postRepository.deleteById(id);
    }
}
