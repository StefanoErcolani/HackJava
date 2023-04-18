package it.aulab.springthymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import it.aulab.springthymeleaf.dto.AuthorDTO;
import it.aulab.springthymeleaf.model.Author;
import it.aulab.springthymeleaf.service.AuthorService;

@Controller
@RequestMapping(value = "authors")
public class AuthorController {
    
    @Autowired
    private AuthorService authorService;

    // @GetMapping
    // public String authorsView(Model model) {
    //     model.addAttribute("title", "Authors");
    //     model.addAttribute("authors", authorService.readEvenMore());
    //     return "nested/authors";
    // }

    @GetMapping("all")
    public String authorsView2(Model model) {
        
        List<AuthorDTO> all = authorService.readAll(); 

        model.addAttribute("title", "Authors");
        model.addAttribute("authors", all);
        return "nested/authors";
    }

    @GetMapping("client")
    public String authorsViewClientSide(Model model){
        model.addAttribute("title", "Authors");
        return "nested/authors_csr";
    }

    @GetMapping("add")
    public String authorsAddFromView(Model model) {
        model.addAttribute("title", "Create Authors");
        model.addAttribute("author", new Author());
        return "nested/newAuthor";

    }

    @PostMapping("save")
    public String authorSave(@ModelAttribute("author") Author author) throws Exception {

        authorService.create(author);
        
        return "redirect:/authors/all";
    }

    @GetMapping("modify/{id}")
    public String authorModify(@PathVariable("id") Long id, Model model) throws Exception {
        model.addAttribute("title", "Update");
        model.addAttribute("author", authorService.readOne(id));
        return "nested/modifyAuthor";
    }

    //anche @pathvariable
    @PostMapping("update")
    public String authorUpdate(@ModelAttribute("author") Author author) throws Exception {
        authorService.update(author.getId(), author);
        return "redirect:/authors/all";
    }
    // @PostMapping("update/{id}")
    // public String authorUpdate(@PathVariable("id") Long id, @ModelAttribute("author") Author author) throws Exception {
    //     authorService.update(id, author);
    //     return "redirect:/authors/all";
    // }
}


// @PostMapping("update/{id}")
//     public String authorUpdateWithId(@PathVariable("id") Long id, @ModelAttribute("pluto") Author author) throws Exception {
//         authorService.update(id, author);
//         return "redirect:/authors";
//     }