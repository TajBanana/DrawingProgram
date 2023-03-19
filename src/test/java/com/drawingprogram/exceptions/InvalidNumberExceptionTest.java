package com.drawingprogram.exceptions;

import com.drawingprogram.enums.NumberError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvalidNumberExceptionTest {
  @Test
  public void testWithDefaultMessage() {
    InvalidNumberException exception =
        assertThrows(InvalidNumberException.class,
            () -> {
              throw new InvalidNumberException();
            });

    assertEquals(NumberError.INVALID_NUMBER.toString(),
        exception.getMessage());
  }


}