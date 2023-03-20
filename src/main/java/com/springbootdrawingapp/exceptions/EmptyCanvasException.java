package com.springbootdrawingapp.exceptions;

import com.springbootdrawingapp.enums.CommandError;

public class EmptyCanvasException extends RuntimeException {
  public EmptyCanvasException() {
    super(CommandError.EMPTY_CANVAS.toString());
  }
}
