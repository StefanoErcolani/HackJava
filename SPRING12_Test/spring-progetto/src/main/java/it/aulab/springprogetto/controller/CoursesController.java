package it.aulab.springprogetto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import it.aulab.springprogetto.dto.CourseDTO;
import it.aulab.springprogetto.dto.CreateCourseDTO;
import it.aulab.springprogetto.dto.UpdateCourseDTO;
import it.aulab.springprogetto.service.CrudService;

@Controller
@RequestMapping(value = "courses")
public class CoursesController {
    
    @Autowired
    private CrudService<CourseDTO, CreateCourseDTO, UpdateCourseDTO, Long> courseService;

    @GetMapping
    public  String showCourseListView(Model model) {
        
        model.addAttribute("title", "All courses");
        model.addAttribute("courses", courseService.readAll());
        return "courses";

    }

    @GetMapping("{id}")
    public String modifyCourseView(@PathVariable("id") Long id, Model model) throws Exception{

        model.addAttribute("title", "Update courses");
        model.addAttribute("courses", courseService.readOne(id));
        return "modifyCourse";
    }

    @PostMapping("{id}")
    public String saveCourse(@PathVariable("id") Long id, @RequestBody UpdateCourseDTO updateCourseDTO) throws Exception {
        courseService.update(id, updateCourseDTO);
        return "courses";
    }

    // @GetMapping
    // public String newCourseView(Model model) {
    //     model.addAttribute("title", "Create a course");
    //     return "newCourse";
    // }
}
