package com.pavser.easyblog.backend.services;

import com.pavser.easyblog.backend.entities.Post;

import java.util.List;

public interface PostService {
    List<Post> getAll(int offset);
    Post getById(Long id);
    boolean deleteById(Long id);
    Post create (Post post);
    Post update (Post post);
}
