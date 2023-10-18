package com.homework.crud.service;

import com.homework.crud.model.Book;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
  List<Book> getAllBooks();

  Page<Book> getAllBooks(Pageable pageable);

  Page<Book> searchBooks(String title, Pageable pageable);

  Optional<Book> getBookById(int id);

  Book addBook(Book book);

  Book updateBook(Book book);

  void deleteBook(int id);
}
