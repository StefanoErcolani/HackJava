package it.aulab.springthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    
    
    @GetMapping("/login") 
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/")
    private String root(Model model)  {
        model.addAttribute("title", "Homepage");
        model.addAttribute("authorsPath", "authors/all");
        model.addAttribute("postsPath", "posts/all");
        model.addAttribute("commentsPath", "comments/all");
        return "index";
    }


}
