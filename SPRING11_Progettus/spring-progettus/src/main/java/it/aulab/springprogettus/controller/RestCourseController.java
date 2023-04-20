package it.aulab.springprogettus.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.aulab.springprogettus.DTO.CourseDTO;
import it.aulab.springprogettus.service.CourseService;


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
        for(String p : params.keySet()){
            System.out.println("Key: " + p);
            System.out.println(params.get("Value: " +  p));
        }
        return new ArrayList<CourseDTO>();
        // return courseService.readAll();
    }

}
