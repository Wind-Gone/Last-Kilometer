package com.example.accessingdatamongodb.Controller;

import com.example.accessingdatamongodb.Entity.Post;
import com.example.accessingdatamongodb.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Post")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/getAll")
    public List<Post> getAll(){
        return postService.findAll();
    }

    @PostMapping("/addOne")
    public Post addOne(@RequestBody Post post){
        return postService.addOne(post);
    }

    @PostMapping("/update")
    public Post update(@RequestBody Post post){
        return postService.update(post);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        postService.delete(id);
    }

}
