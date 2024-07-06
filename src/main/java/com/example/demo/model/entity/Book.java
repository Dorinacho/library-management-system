package com.example.demo.model.entity;

import com.example.demo.model.Isbn;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @Column
  private String title;
  @Column
  private Isbn isbn;
  @Column
  private String description;
  @Column
  @ManyToOne
  private Author author;
}
