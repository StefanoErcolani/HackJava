package it.aulab.springtransactionmapping.services;


import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import it.aulab.springtransactionmapping.model.Author;
import it.aulab.springtransactionmapping.model.Post;
import it.aulab.springtransactionmapping.repository.AuthorRepository;
import it.aulab.springtransactionmapping.repository.PostRepository;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    public PostRepository postRepository;

    @Autowired
    public AuthorRepository authorRepository;

    @Autowired 
    public ModelMapper mapper;

    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> read(String firstname, String lastname) {
        
        if(firstname != null && lastname != null) { 
            return authorRepository.findByAuthorWithFirstnameAndLastname(firstname, lastname); 
        } else  if(firstname != null){
            return authorRepository.findByAuthorWithFirstname(firstname);
        } else{ 
            return authorRepository.findAll(); } 
        
    }



    @Override
    @Modifying
    public Author update(Long id, Author author) throws Exception {
        Optional<Author> dbOptionalAuthor = authorRepository.findById(id);
        
        if( dbOptionalAuthor.isPresent()) {
            Author dbAuthor = dbOptionalAuthor.get();
            dbAuthor.setFirstname(author.getFirstname());
            dbAuthor.setLastname(author.getLastname());
            dbAuthor.setEmail(author.getEmail());
            authorRepository.save(dbAuthor);
            return dbAuthor;
        }
        throw new Exception();
    }

    @Override
    @Modifying
    public String delete(Long id) throws Exception {
        // Optional<Author> dbOptionalAuthor = authorRepository.findById(id);
        // if(dbOptionalAuthor.isPresent()) { 
        //     authorRepository.deleteAll();
        //     return "deleted";
        // }
        // throw new Exception();
        
        //refactoring inline variables
        if(authorRepository.findById(id).isPresent()) {
            authorRepository.deleteAll();
            return "deleted";
        }
        throw new Exception();
    }

    @Override
    @Transactional
    public void transaction() {

        postRepository.deleteAll();
        authorRepository.deleteAll();

        Author a1 = new Author();
		a1.setFirstname("null");
		a1.setFirstname("null");
		a1.setEmail("null");

		authorRepository.save(a1);

        Author a2 = new Author();
        a2.setFirstname("Bruno");
        a2.setLastname("Paoli");
        a2.setEmail("brunello@gmail.com");

        authorRepository.save(a2);

		Post p1 = new Post();
        p1.setAuthor(a1);
		p1.setTitle("null");
		p1.setBody("null");
		p1.setPublishDate("null");
        
        postRepository.save(p1);

        Post p2 = new Post();
        p2.setAuthor(a2);
        p2.setTitle("Bel post");
        p2.setBody("Marameo");
        p2.setPublishDate("121311");

        postRepository.save(p2);
    }

    @Override
    public void notransaction() {

        postRepository.deleteAll();
        authorRepository.deleteAll();

        Author a1 = new Author();
		a1.setFirstname("null");
		a1.setFirstname("null");
		a1.setEmail("null");

		authorRepository.save(a1);

        Author a2 = new Author();
        a2.setFirstname("Bruno");
        a2.setLastname("Paoli");
        a2.setEmail("brunello@gmail.com");

        authorRepository.save(a2);

		Post p1 = new Post();
        p1.setAuthor(a1);
		p1.setTitle("null");
		p1.setBody("null");
		p1.setPublishDate("null");
        
        postRepository.save(p1);

        Post p2 = new Post();
        p2.setAuthor(a2);
        p2.setTitle("Bel post");
        p2.setBody("Marameo");
        p2.setPublishDate("121311");

        postRepository.save(p2);
    }
}
