package com.drawingprogram.exceptions;

import com.drawingprogram.enums.CommandError;
import com.drawingprogram.utils.Menu;

public class InvalidCommandException extends RuntimeException{
  public InvalidCommandException() {
    super(CommandError.INVALID_COMMAND.toString());
    Menu.print();
  }
}