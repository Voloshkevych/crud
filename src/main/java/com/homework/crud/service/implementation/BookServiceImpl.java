package com.homework.crud.service.implementation;

import com.homework.crud.exception.BookNotFoundException;
import com.homework.crud.model.Book;
import com.homework.crud.repository.BookRepository;
import com.homework.crud.service.BookService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  @Autowired
  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
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
    return Optional.ofNullable(bookRepository.findById(id)
        .orElseThrow(() -> new BookNotFoundException(id)));
  }

  @Override
  public Book addBook(Book book) {
    return bookRepository.save(book);
  }

  @Override
  public Book updateBook(Book book) {
    if (!bookRepository.existsById(book.getId())) {
      throw new BookNotFoundException(book.getId());
    }
    return bookRepository.save(book);
  }

  @Override
  public void deleteBook(int id) {
    if (!bookRepository.existsById(id)) {
      throw new BookNotFoundException(id);
    }
    bookRepository.deleteById(id);
  }
}
