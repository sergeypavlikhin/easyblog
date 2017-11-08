package com.pavser.easyblog.backend.controllers;

import com.pavser.easyblog.backend.entities.Post;
import com.pavser.easyblog.backend.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class PostsController {

    private PostService postService;

    @RequestMapping(name = "/posts", method = RequestMethod.GET)
    public List<Post> getAll(@RequestParam(required = false, defaultValue = "0") String offset, @RequestParam(required = true) String id){
        Long idLong = Long.parseLong(id);
        Integer offsetInt = Integer.parseInt(offset);
        return postService.getAll(offsetInt);
    }

    @RequestMapping(name = "/posts", method = RequestMethod.PUT)
    public Post updatePost(HttpServletRequest request){
        String postString = request.getParameter("post");
        Post parsedPost = JsonUtils.fromJson(postString, Post.class);
        return postService.update(parsedPost);
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