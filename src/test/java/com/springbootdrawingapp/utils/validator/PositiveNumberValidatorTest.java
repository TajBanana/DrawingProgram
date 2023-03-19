package com.springbootdrawingapp.utils.validator;

import com.springbootdrawingapp.exceptions.InvalidNumberException;
import com.springbootdrawingapp.exceptions.NonIntegerException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PositiveNumberValidatorTest {

  @InjectMocks
  PositiveNumberValidator positiveNumberValidator;

  @Test
  void validateWithPositiveInteger() {
    String validNum = "100";

    try {
      positiveNumberValidator.validate(validNum);
    } catch (Exception e) {
      fail("should not have thrown exception");
    }
  }

  @Test
  void validateWithNegativeInteger() {
    String negativeNum = "-100";
    assertThrows(InvalidNumberException.class,
        () -> positiveNumberValidator.validate(negativeNum));
  }

  @Test
  void validateWithFloat() {
    String floatNum = "-1.1099";
    assertThrows(NonIntegerException.class,
        () -> positiveNumberValidator.validate(floatNum));
  }
}