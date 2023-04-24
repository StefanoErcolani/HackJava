package it.aulab.springthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.springthymeleaf.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    
}
