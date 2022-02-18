package com.absa.bookstoreapi.repository;


import com.absa.bookstoreapi.model.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookOrderRepository extends JpaRepository<BookOrder, Long> {
}
