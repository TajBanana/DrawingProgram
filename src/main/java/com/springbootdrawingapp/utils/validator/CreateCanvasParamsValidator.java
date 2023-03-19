package com.springbootdrawingapp.utils.validator;

import com.springbootdrawingapp.enums.ParamsLengthError;
import com.springbootdrawingapp.exceptions.InvalidCanvasParamException;
import org.springframework.stereotype.Service;

@Service
public class CreateCanvasParamsValidator {

  private final PositiveNumberValidator positiveNumberValidator;

  public CreateCanvasParamsValidator(PositiveNumberValidator positiveNumberValidator) {
    this.positiveNumberValidator = positiveNumberValidator;
  }

  public void validate(String[] params) {
    if (params.length != 2)
      throw new InvalidCanvasParamException(ParamsLengthError.CREATE_COMMAND.toString());

    for (String param: params) {
      positiveNumberValidator.validate(param);
    }
  }
}
