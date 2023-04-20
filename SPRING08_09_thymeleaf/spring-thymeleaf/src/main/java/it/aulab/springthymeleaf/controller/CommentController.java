package it.aulab.springthymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import it.aulab.springthymeleaf.dto.CommentDTO;
import it.aulab.springthymeleaf.dto.CreateCommentDTO;
import it.aulab.springthymeleaf.model.Comment;
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

    @GetMapping("add")
    public String postsAddFromView(Model model) {
        model.addAttribute("title", "Create Posts");
        model.addAttribute("comment", new CreateCommentDTO());
        // model.addAttribute("authors", authorService.readAll());
        return "nested/newComment";

    }

    @PostMapping("save")
    public String commentsSave(@ModelAttribute("comment") CreateCommentDTO createCommentDTO) throws Exception {

        commentService.createCommentDTO(createCommentDTO);
        
        return "redirect:/comments/all";
    }

    @GetMapping("modify/{id}")
    public String commentModify(@PathVariable("id") Long id, Model model) throws Exception {
        model.addAttribute("title", "Update");
        model.addAttribute("comment", commentService.readOne(id));
        return "nested/modifyComment";
    }

    //anche @pathvariable
    @PostMapping("update")
    public String commentUpdate(@ModelAttribute("comment") Comment comment) throws Exception {
        commentService.update(comment.getId(), comment);
        return "redirect:/comments/all";
    }
}
