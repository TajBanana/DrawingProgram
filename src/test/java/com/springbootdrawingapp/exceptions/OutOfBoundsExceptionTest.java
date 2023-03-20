package com.springbootdrawingapp.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OutOfBoundsExceptionTest {
  @Test
  void testConstructor() {
    String errorMsg = "out of Bounds";
    OutOfBoundsException exception = new OutOfBoundsException(errorMsg);
    assertEquals(errorMsg, exception.getMessage());
  }
}