package it.aulab.springtransactionmapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.springtransactionmapping.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    
}
