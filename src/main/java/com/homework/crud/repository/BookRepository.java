package com.homework.crud.repository;

import com.homework.crud.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
  Page<Book> findAll(Pageable pageable);

  Page<Book> findByTitleContaining(String title, Pageable pageable);
}
