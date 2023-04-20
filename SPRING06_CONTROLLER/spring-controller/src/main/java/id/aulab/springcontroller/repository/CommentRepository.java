package id.aulab.springcontroller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import id.aulab.springcontroller.model.Comment;


public interface CommentRepository extends JpaRepository<Comment, Long>{
    
    //Per creare custom repo bisogna costruire una classe concreta che implementa il metodo
    @Query("SELECT c FROM Comment c WHERE c.postDate = '202020'")
    List<Comment> findByCommentWithPostDate202020();

    @Modifying
    @Query("DELETE FROM Comment c WHERE c.id = :id")
    void deleteCommentWithIdParam(@Param("id") Long id);

}
