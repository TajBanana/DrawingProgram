package com.drawingprogram.exceptions;

import com.drawingprogram.enums.CreateCanvasError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InvalidCanvasParamExceptionTest {
  @Test
  public void testWithDefaultMessage() {
    InvalidCanvasParamException exception = Assertions.assertThrows(
        InvalidCanvasParamException.class,
        () -> {
          throw new InvalidCanvasParamException();
        }
    );

    Assertions.assertEquals(CreateCanvasError.INVALID_PARAMS.toString(),
        exception.getMessage());
  }
}