package com.drawingprogram.exceptions;

public class OutOfBoundsException extends RuntimeException {
  public OutOfBoundsException(String errorMessage) {
    super(errorMessage);
  }
}
