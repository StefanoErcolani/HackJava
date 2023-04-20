package it.aulab.springtransactionmapping;

import static org.assertj.core.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import it.aulab.springtransactionmapping.services.AuthorService;
import it.aulab.springtransactionmapping.repository.AuthorRepository;
// import it.aulab.springtransactionmapping.repository.CommentRepository;
// import it.aulab.springtransactionmapping.repository.PostRepository;
// import jakarta.persistence.EntityManager;

@SpringBootTest
class SpringTransactionMappingApplicationTests {

	// @Autowired
	// private EntityManager entityManager;

	@Autowired
	private AuthorRepository authorRepository;

	// @Autowired
	// private PostRepository postRepository;

	// @Autowired
	// private CommentRepository commentRepository;

	@Autowired
	@Qualifier("authorService")
	private AuthorService authorService;

	@Test
	void testFinByAuthorWithFirstnameAndLastname() {

		assertThat(authorRepository.findByAuthorWithFirstnameAndLastname("Franco", "Poldo")).hasSize(1);

	}

	@Test
	void testTransaction() {

		try{

			authorService.transaction();

		} catch(Exception e) { 

			assertThat(authorRepository.findByAuthorWithFirstnameAndLastname("null", "null")).hasSize(0);

		}

	}
}
