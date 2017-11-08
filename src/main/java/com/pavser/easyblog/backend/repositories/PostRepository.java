package com.pavser.easyblog.backend.repositories;

import com.pavser.easyblog.backend.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
