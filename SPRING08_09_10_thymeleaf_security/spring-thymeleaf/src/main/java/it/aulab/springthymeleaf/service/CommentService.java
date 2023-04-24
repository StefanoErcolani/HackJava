package it.aulab.springthymeleaf.service;

import java.util.List;

import it.aulab.springthymeleaf.dto.CommentDTO;
import it.aulab.springthymeleaf.dto.CreateCommentDTO;
import it.aulab.springthymeleaf.model.Comment;

public interface CommentService {
    
    List<CommentDTO> readDTOs();

    CommentDTO readOne(Long id) throws Exception;

    Comment create(Comment comment);
    CommentDTO createCommentDTO(CreateCommentDTO createCommentDTO); 

    String delete(Long id) throws Exception;

    Comment update(Long id, Comment comment) throws Exception;

}
