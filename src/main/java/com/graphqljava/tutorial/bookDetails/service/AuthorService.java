package com.graphqljava.tutorial.bookDetails.service;

import com.graphqljava.tutorial.bookDetails.model.Author;
import com.graphqljava.tutorial.bookDetails.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author getAuthor(int id) {
        return authorRepository.findById(id).orElse(null);
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public List<Author> getAuthorsByIds(List<Integer> ids) {
        return authorRepository.findAllById(ids);
    }
}
