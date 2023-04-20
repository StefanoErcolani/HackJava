package it.aulab.springtransactionmapping.services;

import java.util.List;

import it.aulab.springtransactionmapping.dto.CommentDTO;
import it.aulab.springtransactionmapping.model.Comment;

public interface CommentService {

    Comment create(Comment comment);

    List<CommentDTO> readCommentDTO();

    Comment update(Long id, Comment comment) throws Exception;

    String delete(Long id) throws Exception;

}
