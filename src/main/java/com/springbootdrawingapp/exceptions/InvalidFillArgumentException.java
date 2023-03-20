package com.springbootdrawingapp.exceptions;

public class InvalidFillArgumentException extends RuntimeException {
  public InvalidFillArgumentException(String errorMessage) {
    super(errorMessage);
  }
}
