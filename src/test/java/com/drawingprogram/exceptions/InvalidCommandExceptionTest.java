package com.drawingprogram.exceptions;

import com.drawingprogram.enums.CommandError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InvalidCommandExceptionTest {

  @Test
  public void testWithDefaultMessage() {
    InvalidCommandException exception =
        assertThrows(InvalidCommandException.class,
            () -> {
              throw new InvalidCommandException();
            });

    assertEquals(CommandError.INVALID_COMMAND.toString(),
        exception.getMessage());
  }
}