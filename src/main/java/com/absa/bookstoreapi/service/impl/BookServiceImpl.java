package com.absa.bookstoreapi.service.impl;

import com.absa.bookstoreapi.model.Book;
import com.absa.bookstoreapi.repository.BookRepository;
import com.absa.bookstoreapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    @Override
    public void update(Book book) {
        bookRepository.save(book);
        ;
    }

    @Transactional
    @Override
    public Optional<Book> findOne(Long isbn) {
        return bookRepository.findById(isbn);
    }

    @Transactional
    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

}
