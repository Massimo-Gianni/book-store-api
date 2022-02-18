package com.absa.bookstoreapi.service;

import com.absa.bookstoreapi.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    void add(Book book);

    void update(Book book);

    Optional<Book> findOne(Long isbn);

    List<Book> findAllBooks();

    void delete(Book book);

}
