package com.springbootdrawingapp.utils.validator;

import com.springbootdrawingapp.enums.Commands;
import com.springbootdrawingapp.exceptions.InvalidCommandException;

public class CommandValidator {
  public void validate(String commandString) {
    if (!commandExists(commandString)) {
      throw new InvalidCommandException();
    }
  }

  private static boolean commandExists(String commandString) {
    for (Commands c : Commands.values()) {
      if (c.inputString().equalsIgnoreCase(commandString)) {
        return true;
      }
    }
    return false;
  }
}
