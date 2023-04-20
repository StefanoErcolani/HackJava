package it.aulab.springprogetto.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.aulab.springprogetto.dto.CourseDTO;
import it.aulab.springprogetto.service.CourseService;


@RestController
@RequestMapping("api/courses")
public class RestCourseController {
    
    //con più implementazioni di crud, se si va a fare injection della generic interface -> springBoot trova ambiguità se non si specifica il Qualifier \ inserire direttamente il courseService
    //altrimenti @qualifier e via
    @Autowired
    private CourseService courseService;


    //map param non è required
    @GetMapping
    public List<CourseDTO> get(@RequestParam Map<String, String> params) {
        // for(String p : params.keySet()){
        //     System.out.println("Key: " + p);
        //     System.out.println(params.get("Value: " +  p));
        // }
        // return new ArrayList<CourseDTO>();
        return courseService.readAll();
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Long id) throws Exception{
        return courseService.delete(id);
    }
}