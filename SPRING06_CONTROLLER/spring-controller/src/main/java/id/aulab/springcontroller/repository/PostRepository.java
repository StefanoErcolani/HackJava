package id.aulab.springcontroller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import id.aulab.springcontroller.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    
    @Query("SELECT p FROM Post p WHERE p.title LIKE :title")
    List<Post> findByPostTitle(@Param("title") String title);

}
