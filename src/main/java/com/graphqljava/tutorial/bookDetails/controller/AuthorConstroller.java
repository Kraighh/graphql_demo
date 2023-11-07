package com.graphqljava.tutorial.bookDetails.controller;

import com.graphqljava.tutorial.bookDetails.model.Author;
import com.graphqljava.tutorial.bookDetails.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorConstroller {

    @Autowired
    AuthorService authorService;

    @QueryMapping
    public Author author(@Argument int id) {
        return authorService.getAuthor(id);
    }

    @QueryMapping
    public List<Author> authors() {
        return authorService.getAuthors();
    }
}
