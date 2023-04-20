package it.aulab.springthymeleaf.service;

import java.util.List;

import it.aulab.springthymeleaf.dto.CreatePostDTO;
import it.aulab.springthymeleaf.dto.PostDTO;
import it.aulab.springthymeleaf.model.Post;

public interface PostService {
    
    List<PostDTO> readDTOs();

    PostDTO readOne(Long id) throws Exception;

    // Post create(Post post);

    PostDTO createPostDTO(CreatePostDTO createPostDTO); 

    Post update(Long id, Post post) throws Exception;

    String delete(Long id) throws Exception;
}
