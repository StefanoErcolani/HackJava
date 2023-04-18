package it.aulab.springthymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.aulab.springthymeleaf.dto.PostDTO;
import it.aulab.springthymeleaf.service.PostService;

@Controller
@RequestMapping(value = "posts")
public class PostController {
    
    @Autowired
    private PostService postService;

    @GetMapping("all")
    public String postsView(Model model) {
        
        List<PostDTO> all = postService.readDTOs(); 

        model.addAttribute("title", "Posts");
        model.addAttribute("posts", all);
        return "nested/posts";
    }

}
