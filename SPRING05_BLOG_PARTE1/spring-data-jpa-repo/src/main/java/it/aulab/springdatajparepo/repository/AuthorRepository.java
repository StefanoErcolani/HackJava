package it.aulab.springdatajparepo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.springdatajparepo.model.Author;

//jparepository generic -> indicare entità da gestire e tipo dell'id che deve essere gestito
public interface AuthorRepository extends JpaRepository<Author, Long>{
    
    public List<Author> findByLastname(String lastname);

    public List<Author> findByFirstnameAndLastname(String firstname, String lastname);

    public List<Author> findByFirstnameEquals(String firstname);

    public List<Author> findByFirstnameContains(String firstname);

    
}
