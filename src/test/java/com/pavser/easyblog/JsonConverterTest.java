package com.pavser.easyblog;

import com.pavser.easyblog.backend.JsonUtils;
import com.pavser.easyblog.backend.entities.Post;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class JsonConverterTest {

    @Test
    public void baseTest(){
        Date d = new Date();
        Post post = new Post(1L, "Title", d, "Description", "Some");
        String json = JsonUtils.toJson(post);
        Post postAfter = JsonUtils.fromJson(json, Post.class);
        Assert.assertEquals(post, postAfter);
    }
}
