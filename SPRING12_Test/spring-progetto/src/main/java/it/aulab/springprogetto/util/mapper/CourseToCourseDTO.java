package it.aulab.springprogetto.util.mapper;

import org.modelmapper.PropertyMap;

import it.aulab.springprogetto.dto.CourseDTO;
import it.aulab.springprogetto.model.Course;

public class CourseToCourseDTO extends PropertyMap<Course, CourseDTO>{

    @Override
    protected void configure() {
        using(new ConvertCollectionToInteger()).map(source.getStudents()).setNumberOfStudents(null);
    }
    
}
