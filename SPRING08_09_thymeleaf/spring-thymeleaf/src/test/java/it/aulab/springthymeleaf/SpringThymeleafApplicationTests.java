package it.aulab.springthymeleaf;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import it.aulab.springthymeleaf.model.Author;
import it.aulab.springthymeleaf.model.Comment;
import it.aulab.springthymeleaf.model.Post;
import it.aulab.springthymeleaf.repository.AuthorRepository;
import it.aulab.springthymeleaf.repository.CommentRepository;
import it.aulab.springthymeleaf.repository.PostRepository;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SpringThymeleafApplicationTests {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired 
	private CommentRepository commentRepository;

	@BeforeEach
	@Test
	void createData() {
		commentRepository.deleteAll();
		postRepository.deleteAll();
		authorRepository.deleteAll();;

		Author a1 = new Author();

		a1.setFirstname("Ciro");
		a1.setLastname("Pollidi");
		a1.setEmail("pollino@gmail.com");

		authorRepository.save(a1);

		Post p1 = new Post();
		
		p1.setAuthor(a1);
		p1.setTitle("I ciceruacchi");
		p1.setBody("Leggetevi jacovitti");
		p1.setPublishDate("121123");

		postRepository.save(p1);

		Comment c1 = new Comment();

		c1.setPost(p1);
		c1.setEmail("pollino@gmail.com");
		c1.setBody("Che bello Jacovitti");
		c1.setPostDate("131123");

		commentRepository.save(c1);

		
		assertThat(authorRepository.findAll()).hasSize(1);
		assertThat(postRepository.findAll()).hasSize(1);
		assertThat(commentRepository.findAll()).hasSize(1);

		commentRepository.deleteAll();
		postRepository.deleteAll();
		authorRepository.deleteAll();
	}


}
