package com.pavser.easyblog;

import com.pavser.easyblog.backend.controllers.PostsController;
import com.pavser.easyblog.backend.entities.Post;
import com.pavser.easyblog.backend.services.PostService;
import com.pavser.easyblog.backend.services.PostServiceImpl;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RestControllerTest {

    private PostService postService;
    private PostsController restController;
    private final List<Post> REPOSITORY = new ArrayList<>();

    private final static String TITLE_1 = "Title 1";
    private final static String TITLE_2 = "Title 2";
    private final static String TITLE_3 = "Title 3";

    private final static String TITLE_NEW = "Title 4";

    @Before
    public void setup(){
        REPOSITORY.clear();
        REPOSITORY.add(new Post(1L, TITLE_1, new Date(), "Description", "Simple body"));
        REPOSITORY.add(new Post(2L, TITLE_2, new Date(), "Description", "Simple body"));
        REPOSITORY.add(new Post(3L, TITLE_3, new Date(), "Description", "Simple body"));

        postService = mock(PostService.class);
        when(postService.getAll(anyInt())).thenReturn(REPOSITORY);

        restController = new PostsController();
        restController.setPostService(postService);
    }

    @Test
    public void getAllTest(){
//        Post posts = restController.getById("2", "2");
//        assertThat(posts, CoreMatchers.is(REPOSITORY));
    }

}
