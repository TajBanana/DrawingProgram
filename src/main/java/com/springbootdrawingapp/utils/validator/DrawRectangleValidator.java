package com.springbootdrawingapp.utils.validator;

import com.springbootdrawingapp.enums.ParamsLengthError;
import com.springbootdrawingapp.exceptions.InvalidLineParamsException;
import org.springframework.stereotype.Service;

@Service
public class DrawRectangleValidator {

  private final PositiveNumberValidator positiveNumberValidator;

  public DrawRectangleValidator(PositiveNumberValidator positiveNumberValidator) {
    this.positiveNumberValidator = positiveNumberValidator;
  }

  public void validate(String[] params) {
    if (params.length != 4)
      throw new InvalidLineParamsException(ParamsLengthError.RECTANGLE_COMMAND.toString());

    for (String param : params) {
      positiveNumberValidator.validate(param);
    }
  }
}
