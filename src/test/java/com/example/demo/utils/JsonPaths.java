package com.example.demo.utils;

public class JsonPaths {

  //book
  public static final String PATH_TITLE = "$.title";
  public static final String PATH_ISBN = "$.isbn";
  public static final String PATH_DESCRIPTION = "$.description";
  public static final String PATH_AUTHOR_BIO = "$.author.bio";
  public static final String PATH_AUTHOR_FIRST_NAME = "$.author.firstName";
  public static final String PATH_AUTHOR_LAST_NAME = "$.author.lastName";

  //author
  public static final String PATH_BIO = "$.bio";
  public static final String PATH_FIRST_NAME = "$.firstName";
  public static final String PATH_LAST_NAME = "$.lastName";
  public static final String PATH_BOOK_TITLE = "$.books[0].title";
  public static final String PATH_BOOK_ISBN = "$.books[0].isbn";
  public static final String PATH_BOOK_DESCRIPTION = "$.books[0].description";
}
