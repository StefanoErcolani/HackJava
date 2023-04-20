package it.aulab.springprogettus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.springprogettus.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
