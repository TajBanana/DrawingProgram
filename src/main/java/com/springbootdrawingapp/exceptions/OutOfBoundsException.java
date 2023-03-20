package com.springbootdrawingapp.exceptions;

public class OutOfBoundsException extends RuntimeException {
  public OutOfBoundsException(String errorMessage) {
    super(errorMessage);
  }
}
