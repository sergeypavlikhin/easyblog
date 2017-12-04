package com.pavser.easyblog.backend;

import com.pavser.easyblog.backend.entities.Post;
import com.pavser.easyblog.backend.vo.PostVO;

import java.util.Date;

public class PostConverter {

    public static PostVO toVO(Post post){
        return new PostVO(post.getId(), post.getDate_created().getTime(), post.getTitle(), post.getDescription(), post.getBody());
    }

    public static Post fromVO(PostVO post){
        return new Post(post.getId(), post.getTitle(), new Date(post.getCreated()), post.getDescription(), post.getBody());
    }

}
