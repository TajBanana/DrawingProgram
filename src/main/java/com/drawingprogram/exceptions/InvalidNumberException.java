package com.drawingprogram.exceptions;

import com.drawingprogram.enums.ParamsError;

public class InvalidNumberException extends RuntimeException{
  public InvalidNumberException() {
    super(ParamsError.INVALID_NUMBER.toString());
  }
}
