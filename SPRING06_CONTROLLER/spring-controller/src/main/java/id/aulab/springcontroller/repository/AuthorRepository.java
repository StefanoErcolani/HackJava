package id.aulab.springcontroller.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import id.aulab.springcontroller.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>, CustomAuthRepository{
    
    @Modifying
    @Query("UPDATE Author a SET a.lastname = 'Fanizzi' WHERE a.id = 2")
    void updateAuthorLastNameWithoutParams();

}
