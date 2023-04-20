package it.aulab.springtransactionmapping.util.mapper;

import org.modelmapper.PropertyMap;

import it.aulab.springtransactionmapping.dto.CreatePostDTO;
import it.aulab.springtransactionmapping.model.Post;

public class CreatePostDTOToPostPropertyMap extends PropertyMap<CreatePostDTO, Post>{

    @Override
    protected void configure() {
        map().setId(null);
        map().getAuthor().setId(source.getAuthorId());
    }
    
}
