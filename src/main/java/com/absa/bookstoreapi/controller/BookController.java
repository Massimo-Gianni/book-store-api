package com.absa.bookstoreapi.controller;

import com.absa.bookstoreapi.exception.NotFoundException;
import com.absa.bookstoreapi.model.Book;
import com.absa.bookstoreapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/books")
public class BookController {


    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public void createBook(@RequestBody Book book) {
        bookService.add(book);
    }

    @PutMapping("/{id}")
    public void updateBook(@RequestBody Book book, @PathVariable(name = "id") Long id) {
        Book existingBook = this.bookService.findOne(id).orElseThrow(() -> new NotFoundException("Book not found with ID: " + id));
        existingBook.setISBN(book.getISBN());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setTitle(book.getTitle());
        existingBook.setYearPublished(book.getYearPublished());
        bookService.add(book);
    }

    @GetMapping("/{id}")
    public Book getOneBook(@PathVariable(name = "id") Long id) {
        return bookService.findOne(id).orElseThrow(() -> new NotFoundException("Book not found with ID: " + id));
    }

    @GetMapping
    public List<Book> getExistingContractBooks() {
        return bookService.findAllBooks();
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        Book existingBook = this.bookService.findOne(id).orElseThrow(() -> new NotFoundException("Book not found with ID: " + id));
        this.bookService.delete(existingBook);
    }


}
