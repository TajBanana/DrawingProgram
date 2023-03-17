package com.drawingprogram.utils.validator;

import com.drawingprogram.exceptions.InvalidNumberException;
import com.drawingprogram.exceptions.NonIntegerException;

public class PositiveParamValidator {
  public static void validate(String numString) {
    try {
      int num = Integer.parseInt(numString);

      if (num < 1) throw new InvalidNumberException();

    } catch (NumberFormatException e) {
      throw new NonIntegerException();
    }
  }
}
