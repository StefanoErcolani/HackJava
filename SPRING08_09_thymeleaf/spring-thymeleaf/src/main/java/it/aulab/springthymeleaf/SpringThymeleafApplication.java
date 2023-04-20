package it.aulab.springthymeleaf;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.aulab.springthymeleaf.util.mapper.AuthorToAuthorDTOMapper;
import it.aulab.springthymeleaf.util.mapper.CreateCommentDTOToCommentPropertyMapper;
import it.aulab.springthymeleaf.util.mapper.CreatePostDTOToPostPropertyMapper;
import it.aulab.springthymeleaf.util.mapper.PostToPostDTOMapper;

@SpringBootApplication
public class SpringThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringThymeleafApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();

		CreatePostDTOToPostPropertyMapper createPostDTOToPostPropertyMapper = new CreatePostDTOToPostPropertyMapper();

		CreateCommentDTOToCommentPropertyMapper createCommentDTOToCommentPropertyMapper = new CreateCommentDTOToCommentPropertyMapper();
		
		AuthorToAuthorDTOMapper authorToAuthorDTOMapper = new AuthorToAuthorDTOMapper();

		PostToPostDTOMapper postDTOMapper = new PostToPostDTOMapper();

		mapper.addMappings(createPostDTOToPostPropertyMapper);

		mapper.addMappings(createCommentDTOToCommentPropertyMapper);

		mapper.addMappings(authorToAuthorDTOMapper);
		
		mapper.addMappings(postDTOMapper);

		return mapper;
	}

}
