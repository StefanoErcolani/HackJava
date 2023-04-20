package it.aulab.springprogettus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.springprogettus.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
    
}
