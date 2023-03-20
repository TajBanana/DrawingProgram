package com.springbootdrawingapp.exceptions;

import com.springbootdrawingapp.enums.NumberError;

public class NonIntegerException extends RuntimeException{
  public NonIntegerException() {
    super(NumberError.NON_INTEGER.toString());
  }
}
