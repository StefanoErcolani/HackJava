package it.aulab.springprogetto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String root(Model model) {
        model.addAttribute("title", "index");
        return "index";
    }   

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("title", "Login");
        return "login-view";
    }
}

