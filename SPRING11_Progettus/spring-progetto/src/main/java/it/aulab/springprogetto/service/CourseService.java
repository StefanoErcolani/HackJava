package it.aulab.springprogetto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import it.aulab.springprogetto.dto.CourseDTO;
import it.aulab.springprogetto.dto.CreateCourseDTO;
import it.aulab.springprogetto.dto.UpdateCourseDTO;
import it.aulab.springprogetto.model.Course;
import it.aulab.springprogetto.repository.CourseRepository;

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
        List<CourseDTO> dtos = new ArrayList<CourseDTO>();
        
        Optional<Course> c = courseRepository.findById(id);
        if(c.isPresent()) {

            dtos.add(modelMapper.map(c, CourseDTO.class));

        }
        return dtos;
    }


    //! query con mappa
// #     String query = 'select ';

// #     for(String key: params.keySet()){
// #         query += key + ", "; //! name, teacher_name, teacher_surname
// #     }
// #     query += " from courses where ";

// #     for(String key: params.keySet()){
// #         query += key +  " = " +  params.get(key) + " AND "; //! name, teacher_name, teacher_surname
// #     }


    @Override
    public CourseDTO create(CreateCourseDTO createCourseDTO) {

        return modelMapper.map(createCourseDTO, CourseDTO.class);
        
    }



    @Override
    @Modifying
    public String delete(Long id) throws Exception {
        if(courseRepository.findById(id).isPresent()) {
            courseRepository.deleteById(id);
            return "deleted";
        }
        throw new Exception();
    }

    @Override
    public CourseDTO update(UpdateCourseDTO updateDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<CourseDTO> read(Map<String, String> params) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }


    
}
