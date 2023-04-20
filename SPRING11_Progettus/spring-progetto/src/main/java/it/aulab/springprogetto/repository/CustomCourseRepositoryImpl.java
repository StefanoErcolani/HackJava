package it.aulab.springprogetto.repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import it.aulab.springprogetto.model.Course;
import jakarta.persistence.EntityManager;


public class CustomCourseRepositoryImpl implements CustomCourseRepository{

    @Autowired
    private EntityManager entityManager;



    
}
