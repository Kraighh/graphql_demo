package com.graphqljava.tutorial.bookDetails.controller;

import com.graphqljava.tutorial.bookDetails.model.Author;
import com.graphqljava.tutorial.bookDetails.model.Book;
import com.graphqljava.tutorial.bookDetails.model.dto.BookInput;
import com.graphqljava.tutorial.bookDetails.service.AuthorService;
import com.graphqljava.tutorial.bookDetails.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@SchemaMapping(typeName = "Book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    AuthorService authorService;

    @QueryMapping
    public Book book(@Argument int id) {
        return bookService.getBook(id);
    }

    @QueryMapping
    public List<Book> books() {
        return bookService.getBooks();
    }

    @SchemaMapping
    public Author author(Book book) {
        return authorService.getAuthor(book.getAuthorId());
    }

    @MutationMapping
    public Book createBook(@Argument BookInput bookInput) {
        return bookService.createBook(bookInput);
    }
}
