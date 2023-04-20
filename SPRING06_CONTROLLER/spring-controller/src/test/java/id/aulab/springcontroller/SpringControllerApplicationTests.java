package id.aulab.springcontroller;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;

import id.aulab.springcontroller.model.Author;
import id.aulab.springcontroller.model.Comment;
import id.aulab.springcontroller.model.Post;
import id.aulab.springcontroller.repository.AuthorRepository;
import id.aulab.springcontroller.repository.CommentRepository;
import id.aulab.springcontroller.repository.PostRepository;
import jakarta.persistence.EntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SpringControllerApplicationTests {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private PostRepository postRepository;

	@BeforeEach
	void createDataTest() {

		//authors
		Author a1 = new Author();
		a1.setFirstname("Giuseppe");
		a1.setLastname("Procida");
		a1.setEmail("giusprocida@aulab.it");

		entityManager.persist(a1);

		Author a2 = new Author();
		a2.setFirstname("Franco");
		a2.setLastname("Minnoni");
		a2.setEmail("vrcmnn@aulab.it");

		entityManager.persist(a2);

		Author a3 = new Author();
		a3.setFirstname("Paolo");
		a3.setLastname("Colavezzi");
		a3.setEmail("colavector@aulab.it");

		entityManager.persist(a3);

		//posts
		Post p1 = new Post();
		p1.setAuthor(a1);
		p1.setTitle("articolone");
		p1.setBody("ciao eccomi qua");
		p1.setPublishDate("33");
		postRepository.save(p1);

		Post p2 = new Post();
		p2.setAuthor(a2);
		p2.setTitle("articolone");
		p2.setBody("qualunquamente comunque");
		p2.setPublishDate("121110");
		postRepository.save(p2);

		Post p3 = new Post();
		p2.setAuthor(a3);
		p3.setTitle("maialona");
		p3.setBody("La battaglia di magenta la più forte");
		p3.setPublishDate("090712");
		postRepository.save(p3);

		//comments
		Comment c1 = new Comment();
		c1.setPost(p1);
		c1.setEmail("colavector@aulab.it");
		c1.setBody("Tanto va la gatta al lardo che ci lasia lo zampino");
		c1.setPostDate("202020");

		commentRepository.save(c1);

		Comment c2 = new Comment();
		c2.setPost(p2);
		c2.setEmail("colavector@aulab.it");
		c2.setBody("Chi va con lo zoppo impara a zoppicare");
		c2.setPostDate("202020");

		commentRepository.save(c2);

		Comment c3 = new Comment();
		c3.setPost(p2);
		c3.setEmail("vrcmnn@aulab.it");
		c3.setBody("Se mio nonno avesse tre palle sarebbe una casseruola");
		c3.setPostDate("172002");

		commentRepository.save(c3);

		Comment c4 = new Comment();
		c4.setPost(p3);
		c4.setEmail("giusprocida@aulab.it");
		c4.setBody("I am death, destroyed of worlds");
		c4.setPostDate("121820");

		commentRepository.save(c4);

	}


	@Test
	void checkCommentPersistence() {

		List<Comment> allcomments = entityManager.createQuery("SELECT c FROM Comment c", Comment.class).getResultList();

		assertThat(allcomments.get(3)).extracting("body").isEqualTo("I am death, destroyed of worlds");
		assertThat(allcomments).hasSize(4);
	}

	@Test
	void checkPersistence() {

		List<Author> allAuth = entityManager.createQuery("SELECT a FROM Author a", Author.class).getResultList();

		assertThat(allAuth).hasSize(3);

	}

	@Test
	void customAuthRepository() {

		List<Author> all = authorRepository.findSomething("zz");

		assertThat(all)
			.first()
			.extracting("lastname")
			.isEqualTo("Colavezzi");

		assertThat(all.get(0)).extracting("lastname").isEqualTo("Colavezzi");

	}

	@Test
	void sortCustomAuthRepository() {

		List<Author> all = authorRepository.findAll(Sort.by("lastname").descending()
													.and(
														Sort.by("firstname").descending()
														));

		assertThat(all).extracting("lastname").contains("Colavezzi", atIndex(2));

		assertThat(all).extracting("firstname").contains("Giuseppe", atIndex(0));
	}


	//esercizi
	@Test
	void checkFindByCommentWithPostDate202020() {

		List<Comment> allcomments = commentRepository.findByCommentWithPostDate202020();

		assertThat(allcomments).hasSize(2);

		assertThat(allcomments.get(0)).extracting("post").extracting("title").isEqualTo("articolone");

	}

	@Test
	void checkfindByPostTitle() {

		assertThat(postRepository.findByPostTitle("articolone")).hasSize(2);

	}

	@Test
	void checkUpdateAuthorLastnameWithoutParams() {
		List<Author> all = authorRepository.findAll();


		System.out.println("ciao" + all.get(all.size() - 1).getId());

		authorRepository.updateAuthorLastnameWithoutParams("Ciro", all.get(all.size() - 1).getId());

		all = authorRepository.findAll();

		for (Author a  : all) {

		System.out.println("ciao" + a.getId() + " : " + a.getLastname());
		}



		assertThat(all.get(all.size() - 1)).extracting("lastname").isEqualTo("Ciro");


	}

	@Test
	void checkDeleteCommentWithId() {
		List<Comment> all = commentRepository.findAll();
		// System.out.println(all.get(0).getId());
		assertThat(commentRepository.count()).isEqualTo(4);

		commentRepository.deleteCommentWithIdParam(all.get(0).getId());

		assertThat(commentRepository.count()).isEqualTo(3);
	}

	@Test
	void checkUpdatePost() {

		

		postRepository.updatePost();

		Post p = postRepository.findByPostTitle("porceddu").get(0);

		System.out.println("Alo " + p.getTitle());
	}

}
