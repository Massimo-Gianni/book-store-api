package com.absa.bookstoreapi.service;

import com.absa.bookstoreapi.model.BookOrder;

import java.util.List;
import java.util.Optional;

public interface BookOrderService {
    void add(BookOrder bookOrder);

    void update(BookOrder bookOrder);

    Optional<BookOrder> findOne(Long isbn);

    List<BookOrder> findAllBookOrders();

    void delete(BookOrder bookOrder);
}
