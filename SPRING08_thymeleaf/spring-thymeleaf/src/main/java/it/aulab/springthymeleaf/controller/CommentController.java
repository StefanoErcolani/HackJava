package it.aulab.springthymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import it.aulab.springthymeleaf.dto.CommentDTO;
import it.aulab.springthymeleaf.service.CommentService;

@Controller
@RequestMapping(value = "comments")
public class CommentController {
    
    @Autowired
    private CommentService commentService;

    @GetMapping("all")
    public String commentsView(Model model) {

        List<CommentDTO> all = commentService.readDTOs();

        model.addAttribute("title", "Comments");
        model.addAttribute("comments", all);
        return "nested/comments";
    }
}
