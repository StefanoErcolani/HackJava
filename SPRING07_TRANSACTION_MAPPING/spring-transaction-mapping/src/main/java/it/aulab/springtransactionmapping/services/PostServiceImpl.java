package it.aulab.springtransactionmapping.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import it.aulab.springtransactionmapping.dto.PostDTO;
import it.aulab.springtransactionmapping.model.Post;
import it.aulab.springtransactionmapping.repository.AuthorRepository;
import it.aulab.springtransactionmapping.repository.CommentRepository;
import it.aulab.springtransactionmapping.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired 
    ModelMapper mapper;

    // @Override
    // public PostDTO create(CreatePostDTO createPostDTO) {
    //     Post post1 = mapper.map(createPostDTO, Post.class);
    //     post1 = postRepository.save(post1);
    //     //work around
    //     post1 = postRepository.findById(post1.getId()).get();
    //     return mapper.map(post1, PostDTO.class);
    // }

    
    @Override
    public List<PostDTO> readDTO() {
        
        List<PostDTO> dtos = new ArrayList<PostDTO>();

        for(Post p : postRepository.findAll()) {
            dtos.add(mapper.map(p, PostDTO.class));
        }
        
        return dtos;
    }

    @Override
    @Modifying
    public Post update(Long id, Post post) throws Exception {
        if(postRepository.findById(id).isPresent()) {
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
        // return String.valueOf(id);
        if(postRepository.findById(id).isPresent()) {
            postRepository.deleteById(id);
            return "deleted";
        }
        throw new Exception();
    }
    
}
