package com.homework.crud.service;

import com.homework.crud.model.Book;
import com.homework.crud.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

  private final BookRepository bookRepository;

  @Autowired
  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }

  @Override
  public Page<Book> getAllBooks(Pageable pageable) {
    return bookRepository.findAll(pageable);
  }

  @Override
  public Page<Book> searchBooks(String title, Pageable pageable) {
    return bookRepository.findByTitleContaining(title, pageable);
  }

  @Override
  public Optional<Book> getBookById(int id) {
    return bookRepository.findById(id);
  }

  @Override
  public Book addBook(Book book) {
    return bookRepository.save(book);
  }

  @Override
  public Book updateBook(Book book) {
    return bookRepository.save(book);
  }

  @Override
  public void deleteBook(int id) {
    bookRepository.deleteById(id);
  }
}
