package com.homework.crud.exception;

public class BookNotFoundException extends RuntimeException {

  public BookNotFoundException(int id) {
    super("No book found with id: " + id);
  }
}
