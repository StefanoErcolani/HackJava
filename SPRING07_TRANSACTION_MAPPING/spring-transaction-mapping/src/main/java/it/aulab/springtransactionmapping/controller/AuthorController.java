package it.aulab.springtransactionmapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.aulab.springtransactionmapping.model.Author;
// import it.aulab.springtransactionmapping.repository.AuthorRepository;
import it.aulab.springtransactionmapping.services.AuthorService;

@Controller
@RequestMapping(value = "authors")
public class AuthorController {
    
    // @Autowired
    // private AuthorRepository authorRepository;

    @Autowired 
    private AuthorService authorService;

    //Solo un get nel pollaio
    // @GetMapping
    // public @ResponseBody List<Author> getAll() { 

    //     return authorRepository.findAll();

    // };

    @GetMapping 
    public @ResponseBody List<Author> getAll(@Param("firstname") String firstname, @Param("lastname") String lastname) {
        return authorService.read(firstname, lastname);
    }

    @PostMapping
    public @ResponseBody Author post(@RequestBody Author author) {
        return authorService.create(author);
    }

    @DeleteMapping("{id}")
    public @ResponseBody String delete(@PathVariable("id") Long id) throws Exception {
        return authorService.delete(id);
    }

    @PutMapping("{id}")
    public @ResponseBody Author update(@PathVariable("id") Long id, @RequestBody Author author) throws Exception {
        return authorService.update(id, author);

    }

}
