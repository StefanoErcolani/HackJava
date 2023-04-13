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

import id.aulab.springcontroller.model.Post;
import id.aulab.springcontroller.repository.PostRepository;

@Controller
@RequestMapping(value = "posts")
public class PostController {
    
    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public @ResponseBody List<Post> getAll() {

        return postRepository.findAll();

    }

    @PostMapping
    public @ResponseBody Post post (@RequestBody Post post) {

        return postRepository.save(post);

    }

    @DeleteMapping("{id}")
    public @ResponseBody String delete(@PathVariable("id") Long id) {

        postRepository.deleteById(id);

        return "deleted";

    }

    @PutMapping("{id}")
    public @ResponseBody Post put(@PathVariable("id") Long id, @RequestBody Post post) throws Exception {

        Optional<Post> opPost = postRepository.findById(id);

        if(opPost.isPresent()) {

            Post dbPost = opPost.get();
            dbPost.setTitle(post.getTitle());
            dbPost.setBody(post.getBody());
            dbPost.setPublishDate(post.getPublishDate());
            postRepository.save(dbPost);

            return dbPost;

        }

        throw new Exception();
    }

    

}
