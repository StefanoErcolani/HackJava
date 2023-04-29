package it.aulab.springprogetto.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import it.aulab.springprogetto.dto.CreateLessonDTO;
import it.aulab.springprogetto.dto.LessonDTO;
import it.aulab.springprogetto.dto.UpdateLessonDTO;
import it.aulab.springprogetto.model.Lesson;
import it.aulab.springprogetto.repository.LessonRepository;

public class LessonService implements CrudService<LessonDTO, CreateLessonDTO, UpdateLessonDTO, Long>{
    
    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<LessonDTO> readAll() {
        List<LessonDTO> lessons = new ArrayList<LessonDTO>();

        for(Lesson l : lessonRepository.findAll()) {
            lessons.add(mapper.map(l, LessonDTO.class));
        }

        return lessons;
    }

    @Override
    public LessonDTO readOne(Long id) throws Exception {
        if(lessonRepository.findById(id).isPresent()) {
            return mapper.map(lessonRepository.findById(id).get(), LessonDTO.class);
        }
        throw new Exception();
    }

    @Override
    public List<LessonDTO> read(Map<String, String> params) {
        
        List<Lesson> lessons = new ArrayList<Lesson>();

        return lessons.stream().map((el) -> mapper.map(el, LessonDTO.class)).toList();
    }

    @Override
    public LessonDTO create(CreateLessonDTO createLessonDTO) {
        Lesson lesson = mapper.map(createLessonDTO, Lesson.class);

        return mapper.map(lessonRepository.save(lesson), LessonDTO.class);
    }

    @Override
    public LessonDTO update(Long id, UpdateLessonDTO updateLessonDTO) throws Exception {
        Lesson lesson = lessonRepository.findById(id).get();

        lesson.setDescription(updateLessonDTO.getDescription());

        lesson.setDate(LocalDate.parse(updateLessonDTO.getDate()));

        return mapper.map(lesson, LessonDTO.class);
    }

    @Override
    public LessonDTO delete(Long id) throws Exception {
        Lesson lesson = lessonRepository.findById(id).get();

        LessonDTO lessonDTO = mapper.map(lesson, LessonDTO.class);

        lessonRepository.deleteById(id);

        return lessonDTO;
    }
    
}
