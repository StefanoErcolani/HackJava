package it.aulab.springprogetto.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
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
    public CourseDTO readOne(Long id) throws Exception{
        
        Optional<Course> c = courseRepository.findById(id);
        if(c.isPresent()) {

            return modelMapper.map(c, CourseDTO.class);
        }
        throw new Exception();
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
        Course course = modelMapper.map(createCourseDTO, Course.class);
        return modelMapper.map(courseRepository.save(course), CourseDTO.class);
        
    }



    @Override
    @Modifying
    public CourseDTO delete(Long id) throws Exception {
        Course course = this.exists(id);

        CourseDTO dto = modelMapper.map(course, CourseDTO.class);

        courseRepository.deleteById(id);

        return dto;
    }

    private Course exists(Long id) throws Exception {
        if(courseRepository.existsById(id)) return courseRepository.findById(id).get();

        throw new Exception();
    }

    @Override
    public CourseDTO update(Long id, UpdateCourseDTO updateDTO) throws Exception{
        Course specialCourse = this.exists(id);
        specialCourse.setDescription(updateDTO.getDescription());
        specialCourse.setDate(LocalDate.parse(updateDTO.getDate()));
        courseRepository.save(specialCourse);
        
        return modelMapper.map(specialCourse, CourseDTO.class);

    }

    @Override
    public List<CourseDTO> read(Map<String, String> params) {
        String nameFilter = params.get("name");

        String teacherFirstnameFilter = params.get("teacherFirstname");

        String teacherLastnameFilter = params.get("teacherLastname");
        
        List<Course> courses;

        if(nameFilter != null && teacherFirstnameFilter != null && teacherLastnameFilter != null) {

            courses = courseRepository.findByNameContainingAndTeacherFirstnameContainingAndTeacherLastnameContaining(nameFilter, teacherFirstnameFilter, teacherLastnameFilter);

        } else if(teacherFirstnameFilter != null && teacherLastnameFilter != null) {

            courses = courseRepository.findByTeacherFirstnameContainingAndTeacherLastnameContaining(teacherFirstnameFilter, teacherLastnameFilter);

        } else if(teacherFirstnameFilter != null && nameFilter != null) {

            courses = courseRepository.findByNameContainingAndTeacherFirstnameContaining(teacherFirstnameFilter, nameFilter);

        } else if(teacherLastnameFilter != null && nameFilter != null) {

            courses = courseRepository.findByNameContainingAndTeacherLastnameContaining(nameFilter, teacherLastnameFilter);

        } else if(nameFilter != null) {
            courses = courseRepository.findByNameContaining(nameFilter);

        } else if(teacherFirstnameFilter != null) {
            courses = courseRepository.findByTeacherFirstnameContaining(teacherFirstnameFilter);

        } else if(teacherLastnameFilter != null) {
            courses = courseRepository.findByTeacherLastnameContaining(teacherLastnameFilter);
        } else {
            courses = courseRepository.findAll();
        }
        
        return courses.stream().map((c) -> modelMapper.map(c, CourseDTO.class)).toList();        
        // for(Course c: courses){

        //     dtos.add();

        // }

        // return courses.stream().forEach((c) -> (dtos.add(c).map(c, Course.class))).asList();
    }


    
}
