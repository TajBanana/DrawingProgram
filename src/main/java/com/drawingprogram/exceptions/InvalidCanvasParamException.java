package com.drawingprogram.exceptions;

import com.drawingprogram.enums.CreateCanvasError;

public class InvalidCanvasParamException extends RuntimeException {
  public InvalidCanvasParamException() {
    super(CreateCanvasError.INVALID_PARAMS.toString());
  }
}
