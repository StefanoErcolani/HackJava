package it.aulab.springthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.springthymeleaf.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    
}
