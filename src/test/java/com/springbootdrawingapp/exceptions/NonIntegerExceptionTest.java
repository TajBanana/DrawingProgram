package com.springbootdrawingapp.exceptions;

import com.springbootdrawingapp.enums.NumberError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NonIntegerExceptionTest {
  @Test
  public void testWithDefaultMessage() {
    NonIntegerException exception =
        assertThrows(NonIntegerException.class,
            () -> {
              throw new NonIntegerException();
            });

    assertEquals(NumberError.NON_INTEGER.toString(),
        exception.getMessage());
  }

}