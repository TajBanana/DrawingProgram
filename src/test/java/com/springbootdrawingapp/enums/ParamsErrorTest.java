package com.springbootdrawingapp.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParamsErrorTest {

  @Test
  public void testErrorMessageForInvalidNumberError() {
    String expectedErrorMessage = """

      \u001B[31mInput must be more than 0\u001B[0m
      """;
    String actualErrorMessage = NumberError.INVALID_NUMBER.toString();
    assertEquals(expectedErrorMessage, actualErrorMessage);
  }

  @Test
  public void testErrorMessageForNonIntegerError() {
    String expectedErrorMessage = """

      \u001B[31mInput must be an integer\u001B[0m
      """;
    String actualErrorMessage = NumberError.NON_INTEGER.toString();
    assertEquals(expectedErrorMessage, actualErrorMessage);
  }

}
