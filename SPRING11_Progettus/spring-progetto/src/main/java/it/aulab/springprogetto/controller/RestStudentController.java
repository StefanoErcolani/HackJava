package it.aulab.springprogetto.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.aulab.springprogetto.dto.CreateStudentDTO;
import it.aulab.springprogetto.dto.StudentDTO;
import it.aulab.springprogetto.dto.UpdateStudentDTO;
import it.aulab.springprogetto.model.Course;
import it.aulab.springprogetto.model.Student;
import it.aulab.springprogetto.repository.CourseRepository;
import it.aulab.springprogetto.repository.StudentRepository;
import it.aulab.springprogetto.service.CourseService;
import it.aulab.springprogetto.service.CrudService;

@Controller
@RequestMapping("api/students")
public class RestStudentController {
    
    @Autowired
    private CrudService<StudentDTO, CreateStudentDTO, UpdateStudentDTO, Long> studentService;

    @Autowired 
    private StudentRepository studentRepository;
    
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("{id}/{idCourse}")
    public Student addCourse(@PathVariable("id") Long id, @PathVariable("idCourse") Long idCourse) throws Exception{

        Course course = mapper.map(courseService.readOne(idCourse), Course.class);
        
        Student student = mapper.map(studentService.readOne(id), Student.class);

        course.getStudents().add(student);
        courseRepository.save(course);

        return studentRepository.findById(id).get();

    }


    @DeleteMapping("{id}/{idCourse}")
    public StudentDTO deleteStudent(@PathVariable("id") Long id, @PathVariable("idCourse") Long idCourse) throws Exception {

        return studentService.delete(id);
    }
}
