package com.absa.bookstoreapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "book_order")
public class BookOrder {

    public BookOrder() {
    }

    public BookOrder(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false, referencedColumnName = "id")
    private Book book;

    @Column(name = "quantity", nullable = false)
    private int quantity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
