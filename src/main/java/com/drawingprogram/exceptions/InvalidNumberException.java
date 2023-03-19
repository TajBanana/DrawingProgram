package com.drawingprogram.exceptions;

import com.drawingprogram.enums.NumberError;

public class InvalidNumberException extends RuntimeException{
  public InvalidNumberException() {
    super(NumberError.INVALID_NUMBER.toString());
  }
}
