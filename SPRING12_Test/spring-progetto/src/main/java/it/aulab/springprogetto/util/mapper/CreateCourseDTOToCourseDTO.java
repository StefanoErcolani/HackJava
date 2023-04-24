package it.aulab.springprogetto.util.mapper;

import org.modelmapper.PropertyMap;

import it.aulab.springprogetto.dto.CourseDTO;
import it.aulab.springprogetto.dto.CreateCourseDTO;

public class CreateCourseDTOToCourseDTO extends PropertyMap<CreateCourseDTO, CourseDTO>{

    @Override
    protected void configure() {
        using(new ConvertStringToDate()).map(source.getDate()).setDate(null);
    }
    
}
