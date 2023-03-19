package com.springbootdrawingapp.exceptions;

import com.springbootdrawingapp.enums.ParamsLengthError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InvalidCanvasParamExceptionTest {
  @Test
  public void testWithDefaultMessage() {
    InvalidCanvasParamException exception = assertThrows(
        InvalidCanvasParamException.class,
        () -> {
          throw new InvalidCanvasParamException(ParamsLengthError.CREATE_COMMAND.toString());
        }
    );

    assertEquals(ParamsLengthError.CREATE_COMMAND.toString(),
        exception.getMessage());
  }
}