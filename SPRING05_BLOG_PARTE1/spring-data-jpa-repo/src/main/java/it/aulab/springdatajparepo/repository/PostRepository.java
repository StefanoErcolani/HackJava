package it.aulab.springdatajparepo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.springdatajparepo.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    
    public List<Post> findByTitle(String title);

}
