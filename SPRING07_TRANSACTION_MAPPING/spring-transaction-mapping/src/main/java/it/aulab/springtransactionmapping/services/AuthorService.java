package it.aulab.springtransactionmapping.services;

import java.util.List;

import it.aulab.springtransactionmapping.model.Author;

public interface AuthorService {
    
    Author create(Author author);

    List<Author> read(String firstname, String lastname);

    Author update(Long id, Author author) throws Exception;

    String delete(Long id) throws Exception;

    void transaction();
    void notransaction();

}
