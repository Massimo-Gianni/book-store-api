package com.absa.bookstoreapi.service.impl;


import com.absa.bookstoreapi.model.BookOrder;
import com.absa.bookstoreapi.repository.BookOrderRepository;
import com.absa.bookstoreapi.service.BookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookOrderServiceImpl implements BookOrderService {

    private final BookOrderRepository bookOrderRepository;

    @Autowired
    public BookOrderServiceImpl(BookOrderRepository bookOrderRepository) {
        this.bookOrderRepository = bookOrderRepository;
    }

    @Transactional
    @Override
    public void add(BookOrder bookOrder) {
        bookOrderRepository.save(bookOrder);
    }

    @Transactional
    @Override
    public void update(BookOrder bookOrder) {
        bookOrderRepository.save(bookOrder);
    }

    @Transactional
    @Override
    public Optional<BookOrder> findOne(Long isbn) {
        return bookOrderRepository.findById(isbn);
    }

    @Transactional
    @Override
    public List<BookOrder> findAllBookOrders() {
        return bookOrderRepository.findAll();
    }

    @Override
    public void delete(BookOrder bookOrder) {
        bookOrderRepository.delete(bookOrder);
    }
}
