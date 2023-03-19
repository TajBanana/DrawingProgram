package com.drawingprogram.exceptions;

import com.drawingprogram.enums.NumberError;

public class NonIntegerException extends RuntimeException{
  public NonIntegerException() {
    super(NumberError.NON_INTEGER.toString());
  }
}
