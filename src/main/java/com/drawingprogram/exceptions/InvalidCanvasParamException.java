package com.drawingprogram.exceptions;

import com.drawingprogram.enums.ParamsLengthError;

public class InvalidCanvasParamException extends RuntimeException {
  public InvalidCanvasParamException(String error) {
    super(error);
  }
}
