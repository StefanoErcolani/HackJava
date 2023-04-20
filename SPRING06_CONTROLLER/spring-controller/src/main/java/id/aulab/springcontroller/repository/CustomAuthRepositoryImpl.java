package id.aulab.springcontroller.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import id.aulab.springcontroller.model.Author;
import jakarta.persistence.EntityManager;

@Repository
public class CustomAuthRepositoryImpl implements CustomAuthRepository{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Author> findSomething(String ciaone) {
    // System.out.println("Aiuto");
    return entityManager
            .createQuery("SELECT a FROM Author a WHERE a.lastname LIKE :partialLastname", Author.class)
                .setParameter("partialLastname", "%" + ciaone + "%")
                    .getResultList();

    }

    @Override
    public List<Author> findSomethingElse(String altro) {
        return entityManager
        .createQuery("SELECT a FROM Author a WHERE a.lastname LIKE :partialLastname", Author.class)
            .setParameter("partialLastname", '%' + altro + '%')
                .getResultList();
    }
    
}
