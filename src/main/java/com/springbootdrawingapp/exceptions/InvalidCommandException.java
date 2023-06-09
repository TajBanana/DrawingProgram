package com.springbootdrawingapp.exceptions;

import com.springbootdrawingapp.enums.CommandError;
import com.springbootdrawingapp.factory.Menu;

public class InvalidCommandException extends RuntimeException{
  public InvalidCommandException() {
    super(CommandError.INVALID_COMMAND.toString());
    Menu.print();
  }
}