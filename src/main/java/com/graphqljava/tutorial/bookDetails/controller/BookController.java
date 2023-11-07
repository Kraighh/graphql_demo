package com.graphqljava.tutorial.bookDetails.controller;

import com.graphqljava.tutorial.bookDetails.model.Author;
import com.graphqljava.tutorial.bookDetails.model.Book;
import com.graphqljava.tutorial.bookDetails.model.dto.BookInput;
import com.graphqljava.tutorial.bookDetails.service.AuthorService;
import com.graphqljava.tutorial.bookDetails.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<Book> books(@Argument List<Integer> ids, @Argument List<Integer> authorIds) {
        return bookService.getBooks(ids, authorIds);
    }

    @BatchMapping
    public Mono<Map<Book, Author>> author (List<Book> books) {
        return Mono.fromSupplier(() -> {
            Map<Book, Integer> mapBookAuthorId = books.stream().collect(HashMap::new, (m, v) -> m.put(v, v.getAuthorId()), HashMap::putAll);
            Map<Integer, Author> mapAuthorIdAuthor = authorService.getAuthorsByIds(mapBookAuthorId.values().stream().toList()).stream().collect(HashMap::new, (m, v) -> m.put(v.getId(), v), HashMap::putAll);
            Map<Book, Author> mapBookAuthor = new HashMap<>();
            mapBookAuthorId.forEach((k, v) -> mapBookAuthor.put(k, mapAuthorIdAuthor.get(v)));
            return mapBookAuthor;
        });
    }

    @MutationMapping
    public Book createBook(@Argument BookInput bookInput) {
        return bookService.createBook(bookInput);
    }
}
