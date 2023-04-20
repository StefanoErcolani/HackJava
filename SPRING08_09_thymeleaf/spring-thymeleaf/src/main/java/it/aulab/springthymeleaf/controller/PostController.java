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

import it.aulab.springthymeleaf.dto.CreatePostDTO;
import it.aulab.springthymeleaf.dto.PostDTO;
import it.aulab.springthymeleaf.model.Post;
import it.aulab.springthymeleaf.service.AuthorService;
import it.aulab.springthymeleaf.service.PostService;

@Controller
@RequestMapping(value = "posts")
public class PostController {
    
    @Autowired
    private PostService postService;

    @Autowired
    private AuthorService authorService;


    @GetMapping("all")
    public String postsView(Model model) {
        
        List<PostDTO> all = postService.readDTOs(); 

        model.addAttribute("title", "Posts");
        model.addAttribute("posts", all);
        return "nested/posts";
    }


    @GetMapping("add")
    public String postsAddFromView(Model model) {
        model.addAttribute("title", "Create Posts");
        model.addAttribute("post", new CreatePostDTO());
        model.addAttribute("authors", authorService.readAll());
        return "nested/newPost";

    }

    @PostMapping("save")
    public String postsSave(@ModelAttribute("post") CreatePostDTO createPostDTO) throws Exception {

        postService.createPostDTO(createPostDTO);
        
        return "redirect:/posts/all";
    }

    @GetMapping("modify/{id}")
    public String postModify(@PathVariable("id") Long id, Model model) throws Exception {
        model.addAttribute("title", "Update");
        model.addAttribute("post", postService.readOne(id));
        return "nested/modifyPost";
    }

    // //anche @pathvariable
    @PostMapping("update")
    public String postUpdate(@ModelAttribute("post") Post post) throws Exception {
        postService.update(post.getId(), post);
        return "redirect:/posts/all";
    }

}
