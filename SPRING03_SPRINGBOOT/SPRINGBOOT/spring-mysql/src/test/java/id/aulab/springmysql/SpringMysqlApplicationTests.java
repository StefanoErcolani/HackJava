package id.aulab.springmysql;

import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import id.aulab.springmysql.model.Restaurant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

// @SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SpringMysqlApplicationTests {
	
	@Autowired
	private EntityManager entityManager;
	
	@Test
	void persistenObjectRestauratn() {

		TypedQuery<Restaurant> q = entityManager.createQuery("SELECT r FROM Restaurant r", Restaurant.class);

		Restaurant r = new Restaurant();

		r.setName("Da Ambrogio");
		r.setDescription("Solo carbocrema qua, ah burini");
		r.setNumber_clients(14);

		List<Restaurant> allBefore = q.getResultList();
		allBefore.size();

		Assertions.assertThat(allBefore).hasSize(1);

		entityManager.persist(r);

		List<Restaurant> allAfter = q.getResultList();
		allAfter.size();

		Assertions.assertThat(allAfter).hasSize(2);
		
		// Assertions.assertThat(listname).hasSize();
	}
	
	@Test
	void updateObjectRestaurant() { 

		TypedQuery<Restaurant> q = entityManager.createQuery("SELECT r FROM Restaurant r", Restaurant.class);

		List<Restaurant> all = q.getResultList();
		
		Restaurant r1 = all.get(0);

		String nome = "Da Giuseppe";
		String description = "Vuolsi così colà come si vuole dove si puote";

		r1.setName(nome);
		r1.setDescription(description);

		entityManager.persist(r1);

		List<Restaurant> allAfter = q.getResultList();
		r1 = allAfter.get(0);

		Assertions.assertThat(r1).extracting("name").isEqualTo(nome);
		Assertions.assertThat(r1).extracting("description").isEqualTo(description);

	}	

	@Test
	void checkObjectRestaurantFields() {

		TypedQuery<Restaurant> q = entityManager.createQuery("SELECT r FROM Restaurant r", Restaurant.class);

		Restaurant r = new Restaurant();

		r.setName("Da Ambrogio");
		r.setDescription("Solo carbocrema qua, ah burini");
		r.setNumber_clients(14);

		List<Restaurant> all = q.getResultList();

		entityManager.persist(r);

		Assertions.assertThat(all).extracting("id").isNotNull();
		
	}

	@Test
	void removeObjectRestaurant() {

		TypedQuery<Restaurant> q = entityManager.createQuery("SELECT r FROM Restaurant r", Restaurant.class);

		List<Restaurant> all = q.getResultList();
		
		Restaurant r1 = all.get(0);

		entityManager.persist(r1);

		entityManager.remove(r1);

		List<Restaurant> allAfter = q.getResultList();
		allAfter.size();

		Assertions.assertThat(allAfter).hasSize(0);
	}

}
