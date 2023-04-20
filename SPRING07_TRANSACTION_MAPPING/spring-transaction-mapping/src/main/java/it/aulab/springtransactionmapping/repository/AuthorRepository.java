package it.aulab.springtransactionmapping.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.aulab.springtransactionmapping.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    
    @Query("SELECT a FROM Author a WHERE a.firstname = :firstname AND a.lastname = :lastname")
    List<Author> findByAuthorWithFirstnameAndLastname(@Param("firstname") String firstaname, @Param("lastname") String lastname);

    @Query("SELECT a FROM Author a WHERE a.firstname = :firstname")
    List<Author> findByAuthorWithFirstname(@Param("firstname") String firstname);
}
