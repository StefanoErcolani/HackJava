package it.aulab.springprogettus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.springprogettus.model.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long>{
    
}

