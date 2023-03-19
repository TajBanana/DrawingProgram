package com.springbootdrawingapp.utils.validator;

import com.springbootdrawingapp.exceptions.InvalidCommandException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.springframework.test.util.AssertionErrors.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
public class CommandValidatorTest {

  @InjectMocks
  private CommandValidator commandValidator;

  @Test
  void testValidCommand() {
    String validCommand = "Q";

    try {
      commandValidator.validate(validCommand);
    } catch (InvalidCommandException e) {
      fail("Should not have thrown exception");
    }
  }

  @Test
  void testInvalidCommand() {
    String invalidCommand = "INVALID_COMMAND";

    assertThrows(InvalidCommandException.class,
        () -> commandValidator.validate(invalidCommand));
  }
}