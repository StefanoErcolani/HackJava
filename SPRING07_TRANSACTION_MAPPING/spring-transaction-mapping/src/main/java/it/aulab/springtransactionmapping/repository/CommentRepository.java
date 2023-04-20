package it.aulab.springtransactionmapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.springtransactionmapping.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    
}
