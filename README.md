# Library Management System

This is a mock application for a simple Library Management System developed using Spring Boot.

## Personal thoughts

Due to lack of business requirements, I thought the app like this.<br/>
We can:
- create:
  - an author
  - a book
- view:
  - all the authors, but no details about their books
  - only one author and details about his books
  - all the books and their authors
  - only on book and it's author
- update:
  - the first name, last name and bio of an author
  - the title, isbn and description of a book. The author can be changed only with an existing one 
- delete:
  - an author and all of his books
  - a book

## Requirements

- Java 21
- Spring Boot 3.3.1
- Maven 3.9.5

## Docker and database initialization

This application utilizes Docker for containerization and runs on PostgreSQL 16.

### Initialization

To initialize the PostgreSQL database, run one of the following commands:
- ```docker-compose up```
- ```docker-compose up -d```

### Adding dummy data

To add dummy data run the scripts from [this file](src/main/resources/add_dummy_data.sql)

## Running the application

To build and run the application, use Maven with the Spring Boot plugin:

```mvn spring-boot:run```

## Database migration

Flyway is used for database migration. It manages and applies database changes.
Database migration is configured to run on startup to ensure the database schema is up to date.

