package com.drawingprogram.exceptions;

import com.drawingprogram.enums.NumberError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonIntegerExceptionTest {
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