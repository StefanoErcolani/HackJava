package it.aulab.springprogetto;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.ComponentScan;

import it.aulab.springprogetto.util.mapper.CourseToCourseDTO;
import it.aulab.springprogetto.util.mapper.CreateCourseDTOToCourseDTO;


@SpringBootApplication
public class SpringProgettoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProgettoApplication.class, args);
	}

	@Bean
	public ModelMapper instanceModelMapper(){
		ModelMapper mapper = new ModelMapper();

		mapper.addMappings(new CreateCourseDTOToCourseDTO());
		mapper.addMappings(new CourseToCourseDTO());
		
		return mapper;
	}

}
