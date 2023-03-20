package com.springbootdrawingapp.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotImplementedExceptionTest {
  @Test
  void testConstructor() {
    String errorMsg = "This method is not implemented yet";
    NotImplementedException exception = new NotImplementedException(errorMsg);
    assertEquals(errorMsg, exception.getMessage());
  }
}