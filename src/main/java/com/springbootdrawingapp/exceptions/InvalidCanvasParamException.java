package com.springbootdrawingapp.exceptions;

public class InvalidCanvasParamException extends RuntimeException {
  public InvalidCanvasParamException(String error) {
    super(error);
  }
}
