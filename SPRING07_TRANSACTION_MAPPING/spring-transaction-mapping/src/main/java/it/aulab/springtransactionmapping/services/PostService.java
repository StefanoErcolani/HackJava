package it.aulab.springtransactionmapping.services;

import java.util.List;

import it.aulab.springtransactionmapping.dto.CreatePostDTO;
import it.aulab.springtransactionmapping.dto.PostDTO;
import it.aulab.springtransactionmapping.model.Post;

public interface PostService {
    
    // PostDTO create(CreatePostDTO createPostDTO);

    List<PostDTO> readDTO();

    Post update(Long id, Post post) throws Exception;

    String delete(Long id) throws Exception;

}
