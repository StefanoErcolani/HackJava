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

import it.aulab.springthymeleaf.dto.CreatePostDTO;
import it.aulab.springthymeleaf.dto.PostDTO;
import it.aulab.springthymeleaf.model.Post;
import it.aulab.springthymeleaf.service.PostService;

@RestController
@RequestMapping(value = "api/posts")
public class PostRestController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostDTO> readDTO() {
        return postService.readDTOs();
    }

    // @PostMapping
    // public Post create(@RequestBody Post post) {
    //     return postService.create(post);
    // }

    @PostMapping
    public PostDTO createDTO(@RequestBody CreatePostDTO createPostDTO) {
        return postService.createPostDTO(createPostDTO);
    }

    @PutMapping("{id}")
    public Post update(@PathVariable("id") Long id, @RequestBody Post post) throws Exception {
        return postService.update(id, post);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Long id) throws Exception {
        return postService.delete(id);
    }
}
