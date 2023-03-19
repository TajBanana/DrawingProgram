package com.springbootdrawingapp.utils.validator;

import com.springbootdrawingapp.exceptions.InvalidNumberException;
import com.springbootdrawingapp.exceptions.NonIntegerException;
import org.springframework.stereotype.Service;

@Service
public class PositiveNumberValidator {
  public void validate(String numString) {
    try {
      int num = Integer.parseInt(numString);

      if (num < 1) throw new InvalidNumberException();

    } catch (NumberFormatException e) {
      throw new NonIntegerException();
    }
  }
}
