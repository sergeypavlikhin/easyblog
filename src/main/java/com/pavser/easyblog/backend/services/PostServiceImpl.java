package com.pavser.easyblog.backend.services;

import com.pavser.easyblog.backend.entities.Post;
import com.pavser.easyblog.backend.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("postService")
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;

    @Override
    public List<Post> getAll(int offset) {
        return postRepository.findAll();
    }

    @Override
    public Post getById(Long id) {
        return postRepository.findOne(id);
    }

    @Override
    public boolean deleteById(Long id) {
        postRepository.delete(id);
        return true;
    }

    @Override
    public Post create(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post update(Post post) {
        return postRepository.save(post);
    }

    @Autowired
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
}
