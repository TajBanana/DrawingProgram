package com.drawingprogram.exceptions;

public class InvalidLineParamsException extends RuntimeException{
  public InvalidLineParamsException(String error) {
    super(error);
  }
}
