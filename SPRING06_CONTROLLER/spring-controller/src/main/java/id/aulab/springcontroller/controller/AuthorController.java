package id.aulab.springcontroller.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import id.aulab.springcontroller.model.Author;
import id.aulab.springcontroller.repository.AuthorRepository;

@Controller
@RequestMapping(value = "authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    // @GetMapping
    // public @ResponseBody String hello() {
    //     return "hello";
    // }

    @GetMapping
    public @ResponseBody List<Author> getAll() {
        return authorRepository.findAll();
    }

    @PostMapping
    public @ResponseBody Author post(@RequestBody Author author) {
            return authorRepository.save(author);
    }

    @DeleteMapping("{id}")
    public @ResponseBody String delete(@PathVariable("id") Long id) {

        authorRepository.deleteById(id);
        return "deleted";

    }

    @PutMapping("{id}")
    public @ResponseBody Author put(@PathVariable("id") Long id, @RequestBody Author author) throws Exception {
        //ritorna un Optional
        Optional<Author> dbAuth = authorRepository.findById(id);
        if (dbAuth.isPresent()) {

            Author dbAuthor = dbAuth.get();
            dbAuthor.setFirstname(author.getFirstname());
            dbAuthor.setLastname(author.getLastname());
            dbAuthor.setEmail(author.getEmail());
            authorRepository.save(dbAuthor);

            return dbAuthor;
        }
        throw new Exception();

    } 
}
