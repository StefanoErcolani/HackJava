package it.aulab.springprogetto.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import it.aulab.springprogetto.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

    List<Course> findByNameContaining(String name);
    List<Course> findByTeacherFirstnameContaining(String teacherFirstname);
    List<Course> findByTeacherLastnameContaining(String teacherLastname);

    List<Course> findByNameContainingAndTeacherFirstnameContaining(String name, String teacherFirstname);
    List<Course> findByNameContainingAndTeacherLastnameContaining(String name, String teacherLastname);
    List<Course> findByTeacherFirstnameContainingAndTeacherLastnameContaining(String teacherFirstname, String teacherLastname);
    List<Course> findByNameContainingAndTeacherFirstnameContainingAndTeacherLastnameContaining(String name, String teacherFirstname, String teacherLastname);
    
}
