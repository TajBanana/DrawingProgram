package com.drawingprogram.exceptions;

import com.drawingprogram.enums.ParamsError;
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

    assertEquals(ParamsError.NON_INTEGER.toString(),
        exception.getMessage());
  }

}