package com.example.demo.model.entity;

import jakarta.persistence.Cacheable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.UUID;

@Entity
@Table
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  @Column
  private String firstName;
  @Column
  private String lastName;
  @Column
  private String bio;

  @OneToMany(
      mappedBy = "author",
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  private List<Book> books;

}
