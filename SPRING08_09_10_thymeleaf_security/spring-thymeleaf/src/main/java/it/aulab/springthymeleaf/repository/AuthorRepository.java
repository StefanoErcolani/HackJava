package it.aulab.springthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.springthymeleaf.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
    
}
