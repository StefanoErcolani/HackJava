package it.aulab.springthymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.aulab.springthymeleaf.dto.CommentDTO;
import it.aulab.springthymeleaf.model.Comment;
import it.aulab.springthymeleaf.service.CommentService;

@RestController
@RequestMapping(value = "api/comments")
public class CommentRestController {
    
    @Autowired
    CommentService commentService;

    @GetMapping
    public List<CommentDTO> readDTO() {
        return commentService.readDTOs();
    }

    @PostMapping
    public Comment create(@RequestBody Comment comment) {
        return commentService.create(comment);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Long id) throws Exception{
        return commentService.delete(id);
    }

    @PutMapping("{id}")
    public Comment update(@PathVariable("id") Long id, @RequestBody Comment comment) throws Exception {
        return commentService.update(id, comment);
    }
}
