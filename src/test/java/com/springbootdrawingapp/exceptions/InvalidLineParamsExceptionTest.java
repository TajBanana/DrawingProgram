package com.springbootdrawingapp.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InvalidLineParamsExceptionTest {
  @Test
  void testConstructor() {
    String errorMsg = "Invalid line params";
    InvalidLineParamsException exception = new InvalidLineParamsException(errorMsg);
    assertEquals(errorMsg, exception.getMessage());
  }
}