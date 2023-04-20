package it.aulab.springtransactionmapping.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import it.aulab.springtransactionmapping.dto.CommentDTO;
import it.aulab.springtransactionmapping.model.Comment;
import it.aulab.springtransactionmapping.repository.CommentRepository;
import it.aulab.springtransactionmapping.repository.PostRepository;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<CommentDTO> readCommentDTO() {
        List<CommentDTO> dtos = new ArrayList<CommentDTO>();
        
        for(Comment c : commentRepository.findAll()) {

            dtos.add(mapper.map(c, CommentDTO.class));

        }
        return dtos;
    }

    @Override
    @Modifying
    public Comment update(Long id, Comment comment) throws Exception {
        if(commentRepository.findById(id).isPresent()) {
            Comment dbComment = (commentRepository.findById(id)).get();
            
                dbComment.setEmail(comment.getEmail());
                dbComment.setBody(comment.getBody());
                dbComment.setPostDate(comment.getPostDate());
                commentRepository.save(dbComment);
                return dbComment;
            }
            throw new Exception();
    }
    

    @Override
    @Modifying
    public String delete(Long id) throws Exception {
        if(commentRepository.findById(id).isPresent()) {
            commentRepository.deleteAll();
            return "deleted";
        }
        throw new Exception();
    }


    
}
