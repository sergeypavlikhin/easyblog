package com.pavser.easyblog;

import com.pavser.easyblog.backend.controllers.PostsController;
import com.pavser.easyblog.backend.entities.Post;
import com.pavser.easyblog.backend.services.PostService;
import com.pavser.easyblog.backend.services.PostServiceImpl;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(PostsController.class)
public class RestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PostService postService;

    private final List<Post> REPOSITORY = new ArrayList<>();

    private final static String TITLE_1 = "Title 1";
    private final static String TITLE_2 = "Title 2";
    private final static String TITLE_3 = "Title 3";

    private final static String TITLE_NEW = "Title 4";

    @Test
    public void getAllTest() throws Exception {
        REPOSITORY.clear();
        REPOSITORY.add(new Post(1L, TITLE_1, new Date(), "Description", "Simple body"));
        REPOSITORY.add(new Post(2L, TITLE_2, new Date(), "Description", "Simple body"));
        REPOSITORY.add(new Post(3L, TITLE_3, new Date(), "Description", "Simple body"));

        when(postService.getAll(anyInt())).thenReturn(REPOSITORY);

        mvc.perform(
                get("/api/posts").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[2].id", is(3)))
        ;
    }

}
