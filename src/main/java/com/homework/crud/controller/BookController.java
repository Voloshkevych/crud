package com.homework.crud.controller;

import com.homework.crud.model.Book;
import com.homework.crud.service.BookService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookController {

  private final BookService bookService;

  @Autowired
  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/books")
  public Page<Book> getAllBooks(@PageableDefault(size = 6) Pageable pageable) {
    return bookService.getAllBooks(pageable);
  }

  @GetMapping("/books/search")
  public Page<Book> searchBooks(@RequestParam String title,
      @PageableDefault(size = 6) Pageable pageable) {
    return bookService.searchBooks(title, pageable);
  }

  @GetMapping("/books/{id}")
  public Optional<Book> getBookById(@PathVariable int id) {
    return bookService.getBookById(id);
  }

  @PostMapping("/books")
  public Book addBook(@RequestBody Book book) {
    return bookService.addBook(book);
  }

  @PutMapping("/books/{id}")
  public Book updateBook(@PathVariable int id, @RequestBody Book book) {
    book.setId(id);
    return bookService.updateBook(book);
  }

  @DeleteMapping("/books/{id}")
  public void deleteBook(@PathVariable int id) {
    bookService.deleteBook(id);
  }
}