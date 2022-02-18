package com.absa.bookstoreapi.controller;


import com.absa.bookstoreapi.exception.NotFoundException;
import com.absa.bookstoreapi.model.Book;
import com.absa.bookstoreapi.model.BookOrder;
import com.absa.bookstoreapi.model.dto.BookOrderDTO;
import com.absa.bookstoreapi.service.BookOrderService;
import com.absa.bookstoreapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/bookOrders")
public class BookOrderController {


    private final BookOrderService bookOrderService;

    private final BookService bookService;

    @Autowired
    public BookOrderController(BookOrderService bookOrderService, BookService bookService) {
        this.bookOrderService = bookOrderService;
        this.bookService = bookService;
    }
    

    @PostMapping
    public void createBookOrder(@RequestBody BookOrderDTO bookOrderDTO) {
        Book book = bookService.findOne(bookOrderDTO.getBookId()).orElseThrow(() -> new NotFoundException("BookOrder not found"));
        BookOrder bookOrder = new BookOrder(book, bookOrderDTO.getQuantity());
        bookOrderService.add(bookOrder);
    }

    @PutMapping("/{id}")
    public void updateBookOrder(@RequestBody BookOrder bookOrder, @PathVariable(name = "id") Long id) {
        BookOrder existingBookOrder = this.bookOrderService.findOne(id).orElseThrow(() -> new NotFoundException("Book Order not found with ID: " + id));
        existingBookOrder.setBook(bookOrder.getBook());
        existingBookOrder.setQuantity(bookOrder.getQuantity());
        bookOrderService.add(bookOrder);
    }

    @GetMapping("/{id}")
    public BookOrder getOneBookOrder(@PathVariable(name = "id") Long id) {
        return bookOrderService.findOne(id).orElseThrow(() -> new NotFoundException("Book Order not found with ID: " + id));
    }

    @GetMapping
    public List<BookOrder> getExistingContractBookOrders() {
        return bookOrderService.findAllBookOrders();
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        BookOrder existingBookOrder = this.bookOrderService.findOne(id).orElseThrow(() -> new NotFoundException("Book Order not found with ID: " + id));
        this.bookOrderService.delete(existingBookOrder);
    }
}
