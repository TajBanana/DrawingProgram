package com.springbootdrawingapp.utils.validator;

import com.springbootdrawingapp.enums.CommandError;
import com.springbootdrawingapp.enums.ParamsLengthError;
import com.springbootdrawingapp.exceptions.InvalidLineParamsException;
import com.springbootdrawingapp.exceptions.InvalidFillArgumentException;
import org.springframework.stereotype.Service;

@Service
public class DrawBucketFillParamsValidator {
  private final PositiveNumberValidator positiveNumberValidator;

  public DrawBucketFillParamsValidator(PositiveNumberValidator positiveNumberValidator) {
    this.positiveNumberValidator = positiveNumberValidator;
  }

  public void validate(String[] params) {
    if (params.length != 3)
      throw new InvalidLineParamsException(ParamsLengthError.LINE_COMMAND.toString());

    positiveNumberValidator.validate(params[0]);
    positiveNumberValidator.validate(params[1]);

    if (params[2].length() != 1)
      throw new InvalidFillArgumentException(CommandError.INVALID_FILL.toString());
  }
}
