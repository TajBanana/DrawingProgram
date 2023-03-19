package com.springbootdrawingapp.utils.validator;

import com.springbootdrawingapp.exceptions.InvalidCanvasParamException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateCanvasParamsValidatorTest {

  @Mock
  private PositiveNumberValidator positiveNumberValidator;

  @InjectMocks
  CreateCanvasParamsValidator createCanvasParamsValidator;

  @Test
  void testValidateWithInvalidParamsLength() {
    String[] params = {"1"};
    assertThrows(InvalidCanvasParamException.class, () -> createCanvasParamsValidator.validate(params));
  }

  @Test
  void testValidateWithValidParamsLength() {
    String[] params = {"10", "10"};
    createCanvasParamsValidator.validate(params);
    verify(positiveNumberValidator, times(2)).validate("10");
  }
}