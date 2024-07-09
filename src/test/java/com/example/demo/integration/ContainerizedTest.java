package com.example.demo.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;

@ContextConfiguration(initializers = ContainerizedTest.Initializer.class)
@ActiveProfiles("test")
public abstract class ContainerizedTest {

  public static final ObjectMapper objectMapper = new ObjectMapper();
  public static final PostgreSQLContainer<?> POSTGRES_CONTAINER;


  static {
    POSTGRES_CONTAINER = new PostgreSQLContainer<>("postgres");
    POSTGRES_CONTAINER.start();
  }

  public static class Initializer implements
      ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
      System.setProperty("DB_URL", POSTGRES_CONTAINER.getJdbcUrl());
      System.setProperty("DB_USERNAME", POSTGRES_CONTAINER.getUsername());
      System.setProperty("DB_PASSWORD", POSTGRES_CONTAINER.getPassword());

      TestPropertyValues.of(
          "spring.jpa.hibernate.connection.autocommit=false",
          "spring.datasource.hikari.auto-commit=false"
      ).applyTo(applicationContext.getEnvironment());
    }
  }
}
