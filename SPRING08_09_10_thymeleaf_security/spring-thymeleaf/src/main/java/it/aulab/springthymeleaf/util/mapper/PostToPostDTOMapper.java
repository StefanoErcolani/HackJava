package it.aulab.springthymeleaf.util.mapper;

import org.modelmapper.PropertyMap;

import it.aulab.springthymeleaf.dto.PostDTO;
import it.aulab.springthymeleaf.model.Post;

public class PostToPostDTOMapper extends PropertyMap<Post, PostDTO>{

    @Override
    protected void configure() {
        using(new ConvertCollectionToInteger()).map(source.getComments()).setNumberOfComments(null);
        
        using(new ConvertStringToInteger()).map(source.getBody()).setBodyLength(null);

    }
}
