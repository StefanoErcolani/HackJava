package id.aulab.springcontroller.repository;

import java.util.List;

import id.aulab.springcontroller.model.Author;

public interface CustomAuthRepository{
    
    List<Author> findSomething(String partialLastname);

    List<Author> findSomethingElse(String altro);
}
