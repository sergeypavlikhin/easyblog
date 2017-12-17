package com.pavser.easyblog.backend.controllers;

import com.pavser.easyblog.backend.entities.Post;
import com.pavser.easyblog.backend.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/api")
public class PostsController {

    private PostService postService;

    @GetMapping(value = "/posts")
    public List<Post> getAll(
            @RequestParam(required = false, defaultValue = "0") String offset,
            @RequestParam(required = false) String id){
        Integer offsetInt = Integer.parseInt(offset);
        if (id == null) {
            return postService.getAll(offsetInt);
        } else {
            Long idLong = Long.parseLong(id);
            return Collections.singletonList(postService.getById(idLong));
        }
    }

    @PutMapping(value = "/posts")
    public Post updatePost(@RequestBody Post post){
        return postService.update(post);
    }

    @PostMapping(value = "/posts")
    public Post createPost(@RequestBody Post post){
        return postService.create(post);
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public String error(Throwable t){
        return "Sorry bro, something wrong: " + t.getMessage();
    }

    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }
}
