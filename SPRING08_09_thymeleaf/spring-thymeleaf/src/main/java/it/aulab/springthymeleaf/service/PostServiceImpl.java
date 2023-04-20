package it.aulab.springthymeleaf.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import it.aulab.springthymeleaf.dto.CreatePostDTO;
import it.aulab.springthymeleaf.dto.PostDTO;
import it.aulab.springthymeleaf.model.Post;
import it.aulab.springthymeleaf.repository.AuthorRepository;
import it.aulab.springthymeleaf.repository.PostRepository;

@Service("postService")
public class PostServiceImpl implements PostService{

    @Autowired
    ModelMapper mapper;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public List<PostDTO> readDTOs() {
        
        List<PostDTO> dtos = new ArrayList<PostDTO>();

        for(Post p : postRepository.findAll()) {
            dtos.add(mapper.map(p, PostDTO.class));
        }

        return dtos;
    }

    // @Override
    // public Post create(Post post){
    //     return postRepository.save(post);
    // }

    @Override
    public PostDTO createPostDTO(CreatePostDTO createPostDTO) {
        Post post = mapper.map(createPostDTO, Post.class);
        post = postRepository.save(post);

        post.setAuthor(authorRepository.findById(createPostDTO.getAuthorId()).get());
        return mapper.map(post, PostDTO.class);
    }

    @Override
    @Modifying
    public Post update(Long id, Post post) throws Exception {
        if((postRepository.findById(id)).isPresent()) {
            
            Post dbPost = (postRepository.findById(id)).get();

            dbPost.setTitle(post.getTitle());
            dbPost.setBody(post.getBody());
            dbPost.setPublishDate(post.getPublishDate());

            postRepository.save(dbPost);
            return dbPost;

        }
        throw new Exception();
    }

    @Override
    @Modifying
    public String delete(Long id) throws Exception {
        postRepository.deleteById(id);
        return "deleted";
    }

    @Override
    public PostDTO readOne(Long id) throws Exception{
        Optional<Post> one = postRepository.findById(id);
        if(one.isPresent()) {
            return mapper.map(one.get(), PostDTO.class);
        }
        throw new Exception();
    }


    
}
