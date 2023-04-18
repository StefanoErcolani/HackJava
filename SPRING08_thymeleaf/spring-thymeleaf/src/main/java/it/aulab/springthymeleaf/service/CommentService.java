package it.aulab.springthymeleaf.service;

import java.util.List;

import it.aulab.springthymeleaf.dto.CommentDTO;
import it.aulab.springthymeleaf.model.Comment;

public interface CommentService {
    
    List<CommentDTO> readDTOs();

    Comment create(Comment comment);

    String delete(Long id) throws Exception;

    Comment update(Long id, Comment comment) throws Exception;

}
