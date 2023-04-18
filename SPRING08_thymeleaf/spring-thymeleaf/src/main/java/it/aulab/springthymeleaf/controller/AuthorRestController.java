package it.aulab.springthymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.aulab.springthymeleaf.dto.AuthorDTO;
import it.aulab.springthymeleaf.model.Author;

import it.aulab.springthymeleaf.service.AuthorService;

@RestController
@RequestMapping(value = "api/authors")
public class AuthorRestController {
    
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<AuthorDTO> readDTO(){
        return authorService.readAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AuthorDTO create(@RequestBody Author author) throws Exception {
        return authorService.create(author);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id") Long id) throws Exception {
        return authorService.delete(id);
    }

    @PutMapping("{id}")
    public AuthorDTO update(@PathVariable("id") Long id, @RequestBody Author author) throws Exception {
        return authorService.update(id, author);
    }
}
