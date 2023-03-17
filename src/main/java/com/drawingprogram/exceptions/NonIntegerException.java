package com.drawingprogram.exceptions;

import com.drawingprogram.enums.ParamsError;

public class NonIntegerException extends RuntimeException{
  public NonIntegerException() {
    super(ParamsError.NON_INTEGER.toString());
  }
}
