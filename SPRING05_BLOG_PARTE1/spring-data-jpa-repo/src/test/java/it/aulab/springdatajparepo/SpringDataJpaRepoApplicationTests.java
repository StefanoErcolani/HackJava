package it.aulab.springdatajparepo;


import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
// import org.springframework.boot.test.context.SpringBootTest;


import it.aulab.springdatajparepo.model.Author;
import it.aulab.springdatajparepo.model.Comment;
import it.aulab.springdatajparepo.model.Post;
import it.aulab.springdatajparepo.repository.AuthorRepository;
import it.aulab.springdatajparepo.repository.CommentRepository;
import it.aulab.springdatajparepo.repository.PagAndSortAuthorRepository;
import it.aulab.springdatajparepo.repository.PostRepository;

import static org.assertj.core.api.Assertions.*;


import java.util.List;

import jakarta.persistence.EntityManager;
;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SpringDataJpaRepoApplicationTests {

	//dependecy injection dell'entityManager, NON istanziazione tramite bean
	@Autowired
	private EntityManager entityManager;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private PagAndSortAuthorRepository pagAndSortAuthorRepository;

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentRepository commentRepository;

	//Creare dei dati per test ogni volta che venga avviato un test
	// @BeforeEach
	void createData() {
	// creare dei dati appositi non lavorare mai possibilmente con dati reali
	// e se non invochi persist come lo provi a creare?

		Author auth = new Author();
		auth.setFirstname("Giuseppe");
		auth.setLastname("Procida");
		auth.setEmail("giusprocida@aulab.it");

		entityManager.persist(auth);

		Post p = new Post();
		p.setAuthor(auth);
		p.setTitle("Ma che bel post");
		p.setBody("lorem ipsum quam primula prospero");
		p.setPublishDate("11/12");

		entityManager.persist(p);

		Comment c = new Comment();
		c.setPost(p);
		c.setEmail("giusprocida@aulab.it");
		c.setBody("Questo commento approva il suo post");
		c.setPostDate("IdiMarzo");
		
		Comment c2 = new Comment();
		c2.setPost(p);
		c2.setEmail("giusprocida@aulab.it");
		c2.setBody("I hate lorem ipsum");
		c2.setPostDate("23/7");

		entityManager.persist(c);
		entityManager.persist(c2);
	}

	//Controllare i dati inseriti
	@Test
	void checkData() {

		//ricordarsi il metasql ha delle regole sintattiche speifiche
		//getResultList() per eseguirla direttamente
		//Assertions può essere importato staticamente per non doverlo richiamare ogni volta
		List<Author> a = entityManager.createQuery("SELECT auth FROM Author auth", Author.class)
							.getResultList();

		assertThat(a).hasSize(1);

	}

	@Test 
	void checkPost() {

		List<Post> posts = entityManager.createQuery("SELECT p FROM Post p", Post.class)
							.getResultList();

		assertThat(posts).hasSize(1);
	}

	@Test 
	void checkComment() {
		//Dati dei commenti, controllare la loro persistenza prendendo in considerazione tutti i post presenti -> c.post.id
		List<Post> posts = entityManager.createQuery("SELECT p FROM Post p", Post.class)
							.getResultList();

		//select parametrica di cui a partire dalla prima posizione prendere il primo elemento il List posts e di cui prendere l'id e ricavarne una lista
		//BISOGNA DARE UN PARAMETRO in questo tipo di query
		//un nuovo parametro ?2
		List<Comment> comments = entityManager
									.createQuery("SELECT c FROM Comment c WHERE c.post.id = ?1", Comment.class)
										.setParameter(1, posts.get(0).getId())
											.getResultList();
		
		assertThat(comments).hasSize(2);

	}

	//tre modi diversi per controllare se la repo è collegata, tramite count(), findAll() e findBy()
	@Test 
	void checkAuthorRepository() {
		assertThat(authorRepository.count()).isEqualTo(1);

		assertThat(authorRepository.findAll())
			.first()
				.extracting("firstname")
					.isEqualTo("Giuseppe");

		//prendi il primo in lista e unico
		Author a = authorRepository.findAll().get(0);
		
		//findBy su id -> ottenere dall'oggetto di sopra l'id e quindi il risultato della findBy-> controllare che non sia null, estrarre il lastName e compararlo con quanto inserito
		assertThat(authorRepository.findById(a.getId()).get())
			.isNotNull().extracting("lastname")
				.isEqualTo("Procida");
	}

	@Test 
	void checkFindByLastName() {
		//se si volesse dovrei andare a sovrascrivere isEqualTo dove proviene
		assertThat(authorRepository.findByLastname("Procida"))
			.first()
				.extracting("lastname")
					.isEqualTo("Procida");

	}

	@Test
	void checkfindByFirstnameAndLastname() {

		//semplicemente controllare se esiste o meno ritornarndo il valore
		assertThat(authorRepository.findByFirstnameAndLastname("Pinolo", "Procida"))
			.hasSize(0);
			
	}

	@Test
	void checkfindByFirstnameContains() {
		//Equals uguaglianza stretta
		assertThat(authorRepository.findByFirstnameEquals("giuseppe"))
			.first()
				.extracting("firstname")
					.isEqualTo("Giuseppe");

		assertThat(authorRepository.findByFirstnameContains("p")).hasSize(1);

	}

	//Paginating and sorting repo
	@Test
	void sort() {

		Author auth = new Author();
		auth.setFirstname("Franco");
		auth.setLastname("Cicerone");
		auth.setEmail("francone@aulab.org");
		entityManager.persist(auth);
		//by vuole le proprietà
		// assertThat(pagAndSortAuthorRepository.findAll(Sort.by("lastname")))
		// 	.first()
		// 		.extracting("lastname")
		// 			.isEqualTo("Procida");

		//metodo alternativo
		assertThat(pagAndSortAuthorRepository.findAll(Sort.by("firstname")))
			.extracting("firstname")
				.contains("Franco", "Giuseppe");

		//metodo alternativo dell'alternativo con la ricerca nell'indice per più elementi
		assertThat(pagAndSortAuthorRepository.findAll(Sort.by("firstname")))
			.extracting("firstname")
				.contains("Franco", atIndex(0))
				.contains("Giuseppe", atIndex(1));
	}

	//Per fare questo commentare il beforeEach iniziale
	@Test
	void paging() {

		authorRepository.deleteAll();

		for(int i = 0; i < 100; i++) {

			Author auth = new Author();
			auth.setFirstname(String.valueOf(i));
			auth.setLastname(String.valueOf(i));
			auth.setEmail(String.valueOf(i));
			authorRepository.save(auth);
			
		}

		assertThat(authorRepository.findAll()).hasSize(100);

		assertThat(pagAndSortAuthorRepository.findAll(PageRequest.of(0, 10)))
			.extracting("firstname")
				.contains("1","2", "3", "4", "5");

		assertThat(pagAndSortAuthorRepository.findAll(PageRequest.of(1, 10)).getContent())
			.extracting("firstname")
				.contains("11", atIndex(1))
				.contains("12", atIndex(2));
		
	}


	@BeforeEach
	void createPost() {

		Post p1 = new Post();
		p1.setTitle("La noia");
		p1.setBody("La noia è noiosa");
		p1.setPublishDate("14");

		Post p2 = new Post();
		p2.setTitle("Godendo");
		p2.setBody("Godendo si gode");
		p2.setPublishDate("13*4");

		entityManager.persist(p1);
		entityManager.persist(p2);
	}

	@Test
	void checkPostTitle() {

		assertThat(postRepository.findByTitle("La noia"))
			.extracting("title")
				.contains("La noia", atIndex(0));

		assertThat(postRepository.findAll())
			.extracting("title")
				.contains("Godendo", atIndex(1));
	}

	//altrimenti crea problemi per la pagination
	// @BeforeEach
	void createComment() {
		
		Comment c1 = new Comment();
		c1.setEmail("capursi@libero.org");
		c1.setBody("Ho un'offerta che non potrai rifiutare");
		c1.setPostDate("sette;)");

		Comment c2 = new Comment();
		c2.setEmail("fraconi@libero.org");
		c2.setBody("Pur sempre si tratta di un lavoro onesto");
		c2.setPostDate("xxx");

		entityManager.persist(c1);
		commentRepository.save(c2);
	}

	@Test
	void checkfindByEmailAndPostDate() {

		// List<Comment> c = entityManager.createQuery("SELECT c FROM Comment c", Comment.class).getResultList();

		// assertThat(c).hasSize(2);

		assertThat(commentRepository.findByEmailAndPostDate("fraconi@libero.org", "xxx"))
			.hasSize(1);

	}

	@Test
	void sortPost() {

		assertThat(postRepository.findAll(Sort.by("title")))
		.extracting("title")
			.contains("Godendo", atIndex(0))
			.contains("La noia", atIndex(1));

		assertThat(postRepository.findAll(Sort.by("publishDate")))
			.extracting("publishDate")
				.contains("14", "13*4");
	}

	@Test
	void sortComment() {

		assertThat(commentRepository.findAll(Sort.by("email", "postDate")))
			.extracting("email")
				.contains("capursi@libero.org", "fraconi@libero.org");

	}

	@Test
	void paginateComment() {

		commentRepository.deleteAll();

		for(int i = 0; i < 1000; i++) {
			//come si mette una variaile come stringa dentro le tonde? imbecille
			Comment c1 = new Comment();
			c1.setEmail(String.valueOf(i));
			c1.setBody(String.valueOf(i));
			c1.setPostDate(String.valueOf(i));
			commentRepository.save(c1);
		}

		assertThat(commentRepository.findAll()).hasSize(1000);

		assertThat(commentRepository.findAll(PageRequest.of(13, 10)).getContent()).extracting("email").contains("134", atIndex(4));

	}
}