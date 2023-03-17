package com.drawingprogram.utils.validator;

import com.drawingprogram.exceptions.InvalidCanvasParamException;

public class CreateCanvasParamsValidator {

  public static void validate(String[] params) {
    if (params.length != 2)
      throw new InvalidCanvasParamException();

    PositiveParamValidator.validate(params[0]);
    PositiveParamValidator.validate(params[1]);
  }
}
