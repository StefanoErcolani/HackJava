package it.aulab.springdatajparepo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.springdatajparepo.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

    public List<Comment> findByEmailAndPostDate(String email, String postDate);
}
