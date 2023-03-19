package com.drawingprogram.utils.validator;

import com.drawingprogram.enums.NotImplementedError;
import com.drawingprogram.enums.ParamsLengthError;
import com.drawingprogram.exceptions.InvalidLineParamsException;
import com.drawingprogram.exceptions.NotImplementedException;


public class DrawLineParamsValidator {
  public static void validate(String[] params) {
    if (params.length != 4)
      throw new InvalidLineParamsException(ParamsLengthError.LINE_COMMAND.toString());

    for (String param : params) {
      PositiveNumberValidator.validate(param);
    }

    boolean isDiagonalLine = !(params[0].equals(params[2]) || params[1].equals(params[3]));

    if (isDiagonalLine) {
      throw new NotImplementedException(NotImplementedError.DIAGONAL_LINE.toString());
    }
  }
}
