package it.aulab.springthymeleaf.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import it.aulab.springthymeleaf.dto.CommentDTO;
import it.aulab.springthymeleaf.model.Comment;
import it.aulab.springthymeleaf.repository.CommentRepository;

@Service("commentService")
public class CommentServiceImpl implements CommentService{

    @Autowired
    ModelMapper mapper;

    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<CommentDTO> readDTOs() {
        
        List<CommentDTO> dtos = new ArrayList<CommentDTO>();
        
        for(Comment c : commentRepository.findAll()) {

            dtos.add(mapper.map(c, CommentDTO.class));
        }
        return dtos;
    }

    @Override
    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    @Modifying
    public String delete(Long id) throws Exception {
        commentRepository.deleteById(id);
        return "deleted";
    }

    @Override
    @Modifying
    public Comment update(Long id, Comment comment) throws Exception {
        Optional<Comment> optionalComment = commentRepository.findById(id);

        if(optionalComment.isPresent()) {

            Comment dbComment = (commentRepository.findById(id)).get();

            dbComment.setEmail(comment.getEmail());
            dbComment.setBody(comment.getBody());
            dbComment.setPostDate(comment.getPostDate());

            commentRepository.save(dbComment);
            return dbComment;
        }
        throw new Exception();
    }
    
}
