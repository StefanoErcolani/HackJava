package it.aulab.springthymeleaf.util.mapper;

import org.modelmapper.PropertyMap;

import it.aulab.springthymeleaf.dto.AuthorDTO;
import it.aulab.springthymeleaf.model.Author;

public class AuthorToAuthorDTOMapper extends PropertyMap<Author, AuthorDTO>{

    @Override
    protected void configure() {
        using(new ConvertCollectionToInteger()).map(source.getPosts()).setNumberOfPosts(null);
    }
    
}
