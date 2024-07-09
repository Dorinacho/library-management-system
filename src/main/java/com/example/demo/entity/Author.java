package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@Table(name = "authors")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Author extends BaseEntity{

  @Column(nullable = false)
  private String firstName;
  @Column(nullable = false)
  private String lastName;
  @Column(nullable = false)
  private String bio;

  @OneToMany(
      mappedBy = "author",
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  private List<Book> books;
}
