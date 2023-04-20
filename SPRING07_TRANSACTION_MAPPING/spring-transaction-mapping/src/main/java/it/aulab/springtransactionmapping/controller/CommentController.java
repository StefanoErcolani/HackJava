package it.aulab.springtransactionmapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import it.aulab.springtransactionmapping.dto.CommentDTO;
import it.aulab.springtransactionmapping.model.Comment;
import it.aulab.springtransactionmapping.services.CommentService;


@Controller
@RequestMapping(value = "comments")
public class CommentController {
    
    @Autowired
    private CommentService commentService;

    @GetMapping 
    public @ResponseBody List<CommentDTO> getDtos() {
        return commentService.readCommentDTO();
    }

    @PostMapping
    public @ResponseBody Comment post(@RequestBody Comment comment) {
        return commentService.create(comment);

    }

    @DeleteMapping("{id}")
    public @ResponseBody String delete(@PathVariable("id") Long id) throws Exception{
        return commentService.delete(id);

    }

    @PutMapping("{id}")
    public @ResponseBody Comment put(@PathVariable("id") Long id, @RequestBody Comment comment) throws Exception {
        return commentService.update(id, comment);

    }

}
