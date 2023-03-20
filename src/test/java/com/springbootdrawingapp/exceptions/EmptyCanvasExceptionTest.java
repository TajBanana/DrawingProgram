package com.springbootdrawingapp.exceptions;

import com.springbootdrawingapp.enums.CommandError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmptyCanvasExceptionTest {
  @Test
  void testConstructor() {
    String errorMsg = CommandError.EMPTY_CANVAS.toString();
    EmptyCanvasException exception = new EmptyCanvasException();
    assertEquals(errorMsg, exception.getMessage());
  }
}