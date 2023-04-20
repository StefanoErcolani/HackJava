package it.aulab.springthymeleaf.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import it.aulab.springthymeleaf.dto.AuthorDTO;
import it.aulab.springthymeleaf.model.Author;
import it.aulab.springthymeleaf.repository.AuthorRepository;
import it.aulab.springthymeleaf.util.exceptions.AuthorNotFound;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    ModelMapper mapper;

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<AuthorDTO> readAll() {
        List<AuthorDTO> dtos = new ArrayList<AuthorDTO>();

        for(Author a : authorRepository.findAll()) {

            dtos.add(mapper.map(a, AuthorDTO.class));

        }

        return dtos;
    }

    @Override 
    public AuthorDTO readOne(Long id) throws Exception {
        Optional<Author> one = authorRepository.findById(id);
        if(one.isPresent()) {
            return mapper.map(one.get(), AuthorDTO.class);

        }
        throw new Exception();
    }

    @Override
    public List<Author> readEvenMore() {
        return authorRepository.findAll();
    }

    @Override
    public AuthorDTO create(Author author) throws Exception {
        if(author.getFirstname() == null || author.getLastname() == null || author.getEmail() == null) { 
            throw new Exception(); 
        }
        return mapper.map(authorRepository.save(author), AuthorDTO.class);
    }

    @Override
    @Modifying
    public String delete(Long id) throws Exception {
        if((authorRepository.findById(id)).isPresent()) {
            authorRepository.deleteById(id);
            return "deleted";
        }
        throw new AuthorNotFound();
    }

    @Override
    @Modifying
    public AuthorDTO update(Long id, Author author) throws Exception {
        Optional<Author> optionalAuthor = authorRepository.findById(id);

        if(optionalAuthor.isPresent()) {
            Author dbAuthor = (authorRepository.findById(id)).get();

            dbAuthor.setFirstname(author.getFirstname());
            dbAuthor.setLastname(author.getLastname());
            dbAuthor.setEmail(author.getEmail());
            authorRepository.save(dbAuthor);
            
            return mapper.map(dbAuthor, AuthorDTO.class);
        }
        throw new AuthorNotFound();
    }


    
}
