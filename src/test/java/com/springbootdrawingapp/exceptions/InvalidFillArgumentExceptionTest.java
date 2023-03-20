package com.springbootdrawingapp.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InvalidFillArgumentExceptionTest {
  @Test
  void testConstructor() {
    String errorMsg = "Invalid fill argument";
    InvalidFillArgumentException exception = new InvalidFillArgumentException(errorMsg);
    assertEquals(errorMsg, exception.getMessage());
  }
}