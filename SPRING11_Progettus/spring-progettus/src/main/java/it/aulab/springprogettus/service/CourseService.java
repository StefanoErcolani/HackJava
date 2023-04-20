package it.aulab.springprogettus.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.aulab.springprogettus.DTO.CourseDTO;
import it.aulab.springprogettus.DTO.CreateCourseDTO;
import it.aulab.springprogettus.DTO.UpdateCourseDTO;
import it.aulab.springprogettus.model.Course;
import it.aulab.springprogettus.repository.CourseRepository;

@Service("courseService")
public class CourseService implements CrudService<CourseDTO, CreateCourseDTO, UpdateCourseDTO, Long>{

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CourseDTO> readAll() {
        List<CourseDTO> dtos = new ArrayList<CourseDTO>();

        for(Course c : courseRepository.findAll()) {
            dtos.add(modelMapper.map(c, CourseDTO.class));
        }
        return dtos;
    }

    @Override
    public List<CourseDTO> readOne(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readOne'");
    }

    @Override
    public List<CourseDTO> read(Map<String, String> params) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public CourseDTO create(CreateCourseDTO createDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public CourseDTO update(UpdateCourseDTO updateDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public CourseDTO delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


    
}
