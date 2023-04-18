package it.aulab.springthymeleaf.service;

import java.util.List;

import it.aulab.springthymeleaf.dto.AuthorDTO;
import it.aulab.springthymeleaf.model.Author;



public interface AuthorService {
    
    List<AuthorDTO> readAll();

    List<Author> readEvenMore();

    AuthorDTO readOne(Long id) throws Exception;

    AuthorDTO create(Author author) throws Exception;

    String delete(Long id) throws Exception;

    AuthorDTO update(Long id, Author author) throws Exception;

}
