package it.aulab.springprogetto.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.aulab.springprogetto.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{


}
