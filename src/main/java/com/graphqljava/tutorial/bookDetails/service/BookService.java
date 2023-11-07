package com.graphqljava.tutorial.bookDetails.service;

import com.graphqljava.tutorial.bookDetails.model.Book;
import com.graphqljava.tutorial.bookDetails.model.dto.BookInput;
import com.graphqljava.tutorial.bookDetails.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book getBook(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> getBooks(List<Integer> ids, List<Integer> authorIds) {
        return bookRepository.findAll(
                (root, query, cb) -> cb.and(
                        root.get("id").in(ids),
                        root.get("authorId").in(authorIds)
                )
        );
    }

    public Book createBook(BookInput book) {
        // TODO add mapper
        Book b = new Book();
        b.setName(book.name);
        b.setPageCount(book.pageCount);
        b.setAuthorId(book.authorId);
        return bookRepository.save(b);
    }
}
