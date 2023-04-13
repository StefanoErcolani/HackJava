package it.aulab.springdatajparepo.repository;

import org.springframework.data.repository.ListPagingAndSortingRepository;

import it.aulab.springdatajparepo.model.Author;

public interface PagAndSortAuthorRepository extends ListPagingAndSortingRepository<Author, Long> {
    
}
