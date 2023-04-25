package it.aulab.springprogetto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import it.aulab.springprogetto.dto.CourseDTO;
import it.aulab.springprogetto.dto.CreateCourseDTO;
import it.aulab.springprogetto.dto.UpdateCourseDTO;
import it.aulab.springprogetto.repository.StudentRepository;
import it.aulab.springprogetto.service.CrudService;

@Controller
@RequestMapping(value = "courses")
public class CoursesController {
    
    @Autowired
    private CrudService<CourseDTO, CreateCourseDTO, UpdateCourseDTO, Long> courseService;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public  String showCourseListView(Model model) {
        
        model.addAttribute("title", "All courses");
        model.addAttribute("courses", courseService.readAll());
        return "courses";

    }

    // @GetMapping("{id}")
    // public String modifyCourseView(@PathVariable("id") Long id, Model model) throws Exception{

    //     model.addAttribute("title", "Update courses");
    //     model.addAttribute("courses", courseService.readOne(id));
    //     return "modifyCourse";
    // }
    @GetMapping("{id}")
    public String modifyCourseView(@PathVariable("id") Long id, Model model) throws Exception{
        CourseDTO courseDTO = courseService.readOne(id);
        
        model.addAttribute("title", "Update course");
        model.addAttribute("course", courseDTO);
        model.addAttribute("students", studentRepository.findAll());

        // System.out.println("STUDENTI PASSATI DAL CORSO: " + courseDTO.getStudents());

        return "modifyCourse";
    }


    @PostMapping("{id}")
    public String saveCourse(@PathVariable("id") Long id, @RequestBody UpdateCourseDTO updateCourseDTO) throws Exception {
        courseService.update(id, updateCourseDTO);
        return "courses";
    }

    @GetMapping("create")
    public String newCourseView(Model model) {
        model.addAttribute("title", "Create your Course");
        model.addAttribute("course", new CreateCourseDTO());
        return "newCourse";
    }

    @PostMapping("save")
    public String courseCreate(@ModelAttribute("course") CreateCourseDTO createCourseDTO) throws Exception {
        courseService.create(createCourseDTO);
        return "redirect:/courses";
    }
}

