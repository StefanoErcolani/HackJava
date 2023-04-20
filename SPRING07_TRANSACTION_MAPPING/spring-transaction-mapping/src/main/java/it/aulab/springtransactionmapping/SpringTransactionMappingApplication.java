package it.aulab.springtransactionmapping;

import org.modelmapper.ModelMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.aulab.springtransactionmapping.util.mapper.CreatePostDTOToPostPropertyMap;

@SpringBootApplication
public class SpringTransactionMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTransactionMappingApplication.class, args);
	}

	//modelmapper ha diversi modi per poter rimappare cose -> propertyMap accetta due generics
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();

		
		
		// PropertyMap<CreatePostDTO, Post> createPostDtoToPostMapping = new PropertyMap<CreatePostDTO, Post>() {	protected void configure() {
		// 	map().setId(null);
		// 	map().getAuthor().setId(source.getAuthorId());
		// 	}
		// };
		// mapper.addMappings(createPostDtoToPostMapping);

		CreatePostDTOToPostPropertyMap createPostDTOToPostMap = new CreatePostDTOToPostPropertyMap();

		mapper.addMappings(createPostDTOToPostMap);

		return mapper;
	}
}	
	//map restituisce l'oggetto che sta mappando cioè post
	//mappare l'oggetto relazionato a post ->  uno dei metodi:
	//source obj -> createPostDTO
	//questo mapping si può prendere da db tramite i provider di modelMapper
	//addMappings() funzione specifica per aggiungere questo mapping a ModelMapper