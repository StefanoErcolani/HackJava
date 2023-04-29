package it.aulab.springprogetto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.springprogetto.model.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long>{
    
    List<Lesson> findByDescription(String description);
}
