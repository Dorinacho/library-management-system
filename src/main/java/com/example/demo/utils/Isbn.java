package com.example.demo.utils;

import java.util.Random;

public final class Isbn {

  private Isbn() {
  }

  private static final String PREFIX_ELEMENT = "978";

  public static String generateIsbn() {
    String registrantElement = generateRandomString();
    String registrationGroupElement = generateRandomString();
    String publicationElement = generateRandomString();
    int checkDigit = new Random().nextInt(10);

    return PREFIX_ELEMENT + "-" + registrantElement + "-" + registrationGroupElement + "-"
        + publicationElement + "-" + checkDigit;
  }

  private static String generateRandomString() {
    Random random = new Random();
    return String.valueOf(random.nextInt(1000));
  }
}
