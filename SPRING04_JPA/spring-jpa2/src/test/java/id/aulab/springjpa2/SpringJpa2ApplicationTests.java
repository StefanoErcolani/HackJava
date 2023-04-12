package id.aulab.springjpa2;


import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.context.SpringBootTest;

import id.aulab.springjpa2.model.Clients;
import id.aulab.springjpa2.model.Menu;
import id.aulab.springjpa2.model.Restaurant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SpringJpa2ApplicationTests {

	@Autowired EntityManager entityManager;

	@Test
	void checkMenu() {

		TypedQuery<Menu> r = entityManager.createQuery("SELECT r FROM Menu r", Menu.class);
		List<Menu> r2 = r.getResultList();

		Assertions.assertThat(r2).hasSize(4);
	}

	@Test
	void objectRestaurantPersistence(){

		TypedQuery<Restaurant> r = entityManager.createQuery("SELECT r FROM Restaurant r", Restaurant.class);
		// List<Restaurant> r2 = r.getResultList();

		Restaurant rest = new Restaurant();

		rest.setName("Giorgio");
		rest.setDescription("Bellissimo, grazie!");
		rest.setNumber_clients(1);

		List<Restaurant> r2 = r.getResultList();
		Assertions.assertThat(r2).hasSize(1);

		entityManager.persist(rest);

		
		List<Restaurant> afterAll = r.getResultList();
		Assertions.assertThat(afterAll).hasSize(2);

	}

	@Test
	void manyToOneRelationalPersistence() { 

		TypedQuery<Restaurant> r = entityManager.createQuery("SELECT r FROM Restaurant r WHERE r.id = 1", Restaurant.class);
		Restaurant restaurant = r.getSingleResult();

		TypedQuery<Menu> m = entityManager.createQuery("SELECT m FROM Menu m WHERE m.id = 1", Menu.class);
		Menu menu = m.getSingleResult();

		Assertions.assertThat(menu).extracting("restaurant").isEqualTo(restaurant);

	}

	@Test
	void oneToManyRelationalPersistence() {

		TypedQuery<Restaurant> r = entityManager.createQuery("SELECT r FROM Restaurant r WHERE r.id = 1", Restaurant.class);
		Restaurant r2 = r.getSingleResult();

		Assertions.assertThat(r2).extracting("menu").asList().hasSize(4);

	}

	@Test
	void checkMenuForClients() {

		//Linguaggio nativo della JPA
		TypedQuery<Menu> m = entityManager.createQuery("SELECT m FROM Menu m", Menu.class);
		List<Menu> menu = m.getResultList();

		Assertions.assertThat(menu.get(0)).extracting("clients").asList().hasSize(2);
		Assertions.assertThat(menu.get(1)).extracting("clients").asList().hasSize(1);
		
	}

	@Test
	void checkClientsFromMenu() { 

		String sql = "SELECT c FROM Clients c WHERE id =";
		TypedQuery<Clients> c = entityManager.createQuery(sql + "1", Clients.class);
		List<Clients> cl = c.getResultList();

		Assertions.assertThat(cl).extracting("menu").asList().hasSize(1);

	}

	@Test
	void checkRelationInsert() {

		TypedQuery<Restaurant> r = entityManager.createQuery("SELECT r FROM Restaurant r WHERE r.id = 1", Restaurant.class);
		Restaurant restaurant = r.getSingleResult();

		Menu m = new Menu();
		m.setDishName("insalata russa");
		m.setIngredients("maionese e tanto amore");
		m.setPrice(12);
		m.setRestaurantId(restaurant);

		entityManager.persist(m);

		TypedQuery<Restaurant> queryAll = entityManager.createQuery("SELECT r FROM Restaurant r", Restaurant.class);
		List<Restaurant> restaurantList = queryAll.getResultList();

		Assertions.assertThat(restaurantList.get(0)).extracting("menu").asList().hasSize(5);
	}

	@Test
	void checkDeleteRelation() {
		//creare un nuovo menu e associarlo a un ristorante

		TypedQuery<Restaurant> r = entityManager.createQuery("SELECT r FROM Restaurant r WHERE id = 1", Restaurant.class);
		Restaurant r1 = r.getSingleResult(); 

		Menu m = new Menu();
		m.setDishName("parmigiana");
		m.setIngredients("melanzane e tanto love");
		m.setPrice(3);
		entityManager.persist(m);

		r1.getMenu().add(m);

		//salvare la relazione tramite persist
		entityManager.persist(r1);

		TypedQuery<Restaurant> rest = entityManager.createQuery("SELECT r FROM Restaurant r", Restaurant.class);
		List<Restaurant> allr = rest.getResultList();

		Assertions.assertThat(allr.get(0)).extracting("menu").asList().hasSize(5);

		entityManager.remove(r1);

		TypedQuery<Menu> allm = entityManager.createQuery("SELECT m FROM Menu m WHERE id =" + m.getId(), Menu.class);
		List<Menu> mlist = allm.getResultList();

		Assertions.assertThat(mlist).extracting("restaurant").asList().hasSize(1);
	}
}
