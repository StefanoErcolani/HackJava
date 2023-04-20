package id.aulab.springcontroller.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import id.aulab.springcontroller.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>, CustomAuthRepository{
    
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Author a SET a.lastname = :newlastname WHERE a.id = :id")
    void updateAuthorLastnameWithoutParams(@Param("newlastname") String newlastname, @Param("id") Long id);

}
