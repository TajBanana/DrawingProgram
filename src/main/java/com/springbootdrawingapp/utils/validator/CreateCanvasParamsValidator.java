package com.springbootdrawingapp.utils.validator;

import com.springbootdrawingapp.enums.ParamsLengthError;
import com.springbootdrawingapp.exceptions.InvalidCanvasParamException;

public class CreateCanvasParamsValidator {

  public static void validate(String[] params) {
    if (params.length != 2)
      throw new InvalidCanvasParamException(ParamsLengthError.CREATE_COMMAND.toString());

    for (String param: params) {
      PositiveNumberValidator.validate(param);
    }
  }
}
