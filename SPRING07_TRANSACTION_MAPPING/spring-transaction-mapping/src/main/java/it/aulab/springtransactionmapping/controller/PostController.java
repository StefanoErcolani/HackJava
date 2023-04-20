package it.aulab.springtransactionmapping.controller;

import java.util.List;
import org.modelmapper.ModelMapper;
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

import it.aulab.springtransactionmapping.dto.CreatePostDTO;
import it.aulab.springtransactionmapping.dto.PostDTO;
import it.aulab.springtransactionmapping.model.Post;
import it.aulab.springtransactionmapping.repository.AuthorRepository;
import it.aulab.springtransactionmapping.repository.PostRepository;
import it.aulab.springtransactionmapping.services.PostService;

@Controller
@RequestMapping(value = "posts")
public class PostController {
    
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;

    @Autowired
    AuthorRepository authorRepository;
    
    @Autowired 
    ModelMapper mapper;

    // @GetMapping
    // public @ResponseBody List<Post> getAll() {
    //     return postRepository.findAll();

    // }

    @GetMapping
    public @ResponseBody List<PostDTO> getSomething() {
        return postService.readDTO();
    }


    @PostMapping
    public @ResponseBody PostDTO post(@RequestBody CreatePostDTO createPostDTO) {
        // return createPostDTO;
        Post post1 = mapper.map(createPostDTO, Post.class);
        post1 = postRepository.save(post1);
        // post1 = postRepository.findById(post1.getId()).get();
        post1.setAuthor(authorRepository.findById(createPostDTO.getAuthorId()).get());
        return mapper.map(post1, PostDTO.class);

    }

    @DeleteMapping("{id}")
    public @ResponseBody String delete(@PathVariable("id") Long id) throws Exception{
        return postService.delete(id);

    }

    @PutMapping("{id}")
    public @ResponseBody Post update(@PathVariable("id") Long id, @RequestBody Post post) throws Exception{
        return postService.update(id, post);
    }
}
