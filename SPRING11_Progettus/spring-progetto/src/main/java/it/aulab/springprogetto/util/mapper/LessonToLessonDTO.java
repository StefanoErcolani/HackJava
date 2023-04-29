package it.aulab.springprogetto.util.mapper;

import org.modelmapper.PropertyMap;

import it.aulab.springprogetto.dto.LessonDTO;
import it.aulab.springprogetto.model.Lesson;

public class LessonToLessonDTO extends PropertyMap<Lesson, LessonDTO>{

    @Override
    protected void configure() {
        using(new ConvertStringToDate()).map(source.getDate()).setDate(null);
    }
    


}
