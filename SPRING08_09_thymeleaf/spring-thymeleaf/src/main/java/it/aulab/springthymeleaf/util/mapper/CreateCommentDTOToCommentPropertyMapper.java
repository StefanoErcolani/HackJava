package it.aulab.springthymeleaf.util.mapper;

import org.modelmapper.PropertyMap;

import it.aulab.springthymeleaf.dto.CreateCommentDTO;
import it.aulab.springthymeleaf.model.Comment;


public class CreateCommentDTOToCommentPropertyMapper extends PropertyMap<CreateCommentDTO, Comment>{

    @Override
    protected void configure() {
        map().setId(null);

        map(source.getPostId()).getPost().setId(null);
    }
    
}
