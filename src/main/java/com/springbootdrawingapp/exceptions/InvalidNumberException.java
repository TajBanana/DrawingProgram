package com.springbootdrawingapp.exceptions;

import com.springbootdrawingapp.enums.NumberError;

public class InvalidNumberException extends RuntimeException{
  public InvalidNumberException() {
    super(NumberError.INVALID_NUMBER.toString());
  }
}
