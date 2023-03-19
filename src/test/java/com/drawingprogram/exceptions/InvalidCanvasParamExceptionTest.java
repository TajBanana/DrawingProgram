package com.drawingprogram.exceptions;

import com.drawingprogram.enums.CreateCanvasError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InvalidCanvasParamExceptionTest {
  @Test
  public void testWithDefaultMessage() {
    InvalidCanvasParamException exception = assertThrows(
        InvalidCanvasParamException.class,
        () -> {
          throw new InvalidCanvasParamException();
        }
    );

    assertEquals(CreateCanvasError.INVALID_PARAMS.toString(),
        exception.getMessage());
  }
}