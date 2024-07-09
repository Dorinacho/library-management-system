# Library Management System

This is a mock application for a simple Library Management System developed using Spring Boot.

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

### Configuration

Database migration is configured to run on startup to ensure the database schema is up to date.
Ensure proper configuration in the flyway-maven-plugin for database URL, username, and password.

