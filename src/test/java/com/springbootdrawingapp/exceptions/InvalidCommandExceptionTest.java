package com.springbootdrawingapp.exceptions;

import com.springbootdrawingapp.enums.CommandError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

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