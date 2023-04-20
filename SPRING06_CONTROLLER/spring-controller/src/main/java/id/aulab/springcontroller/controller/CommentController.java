package id.aulab.springcontroller.controller;

import java.util.List;
import java.util.Optional;

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

import id.aulab.springcontroller.model.Comment;
import id.aulab.springcontroller.repository.CommentRepository;
// import jakarta.annotation.PostConstruct;

@Controller
@RequestMapping(value = "comments")
public class CommentController {
    
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping
    public @ReponseBody List<Comment> getAll() {

        return commentRepository.findAll();

    }

    @PostMapping
    public @ResponseBody Comment put(@RequestBody Comment comment) {

        return commentRepository.save(comment);

    }


    @DeleteMapping("{id}")
    public @ResponseBody String delete(@PathVariable("id") Long id) {

        commentRepository.deleteById(id);

        return "deleted";

    }

    @PutMapping("{id}")
    public @ResponseBody Comment put(@PathVariable("id") Long id, Comment comment) throws Exception{

        Optional<Comment> opcomment = commentRepository.findById(id);

        if(opcomment.isPresent()) {

            Comment dbComment = opcomment.get();

            dbComment.setEmail(comment.getEmail());
            dbComment.setBody(comment.getBody());
            dbComment.setPostDate(comment.getPostDate());
            commentRepository.save(dbComment);

            return dbComment;
        }

        throw new Exception();
    }
}
