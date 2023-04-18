package it.aulab.springthymeleaf.util.mapper;

import org.modelmapper.PropertyMap;

import it.aulab.springthymeleaf.dto.CreatePostDTO;
import it.aulab.springthymeleaf.model.Post;

public class CreatePostDTOToPostPropertyMapper extends PropertyMap<CreatePostDTO, Post> {

    @Override
    protected void configure() {
        map().setId(null);

        map(source.getAuthorId()).getAuthor().setId(null);
    }
    
}
