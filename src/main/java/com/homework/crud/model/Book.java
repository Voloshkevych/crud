package com.homework.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotBlank(message = "Title cannot be empty")
  @Column(nullable = false)
  private String title;

  @NotBlank(message = "Author cannot be empty")
  @Column(nullable = false)
  private String author;

  @Min(value = 1, message = "Publication year cannot be less than 1")
  @Max(value = 2023, message = "Publication year cannot be greater than 2023")
  @Column(name = "publication_year", nullable = false)
  private int publicationYear;
}