package com.springbootdrawingapp.utils.validator;

import com.springbootdrawingapp.enums.NotImplementedError;
import com.springbootdrawingapp.enums.ParamsLengthError;
import com.springbootdrawingapp.exceptions.InvalidLineParamsException;
import com.springbootdrawingapp.exceptions.NotImplementedException;
import org.springframework.stereotype.Service;

@Service
public class DrawLineParamsValidator {

  private final PositiveNumberValidator positiveNumberValidator;

  public DrawLineParamsValidator(PositiveNumberValidator positiveNumberValidator) {
    this.positiveNumberValidator = positiveNumberValidator;
  }

  public void validate(String[] params) {
    if (params.length != 4)
      throw new InvalidLineParamsException(ParamsLengthError.LINE_COMMAND.toString());

    for (String param : params) {
      positiveNumberValidator.validate(param);
    }

    boolean isDiagonalLine = !(params[0].equals(params[2]) || params[1].equals(params[3]));

    if (isDiagonalLine) {
      throw new NotImplementedException(NotImplementedError.DIAGONAL_LINE.toString());
    }
  }
}
