package com.springbootdrawingapp.utils.validator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ParamsValidatorTest {

  @Mock
  private CreateCanvasParamsValidator createCanvasParamsValidator;
  @Mock
  private DrawLineParamsValidator drawLineParamsValidator;
  @Mock
  private DrawRectangleParamsValidator drawRectangleValidator;
  @Mock
  private DrawBucketFillParamsValidator drawBucketFillParamsValidator;

  @InjectMocks
  private ParamsValidator paramsValidator;

  @Test
  void shouldValidateCreateCanvasParams() {
    String command = "C";
    String[] params = {"10", "20"};
    paramsValidator.validate(command, params);
    verify(createCanvasParamsValidator).validate(params);
    verifyNoMoreInteractions(drawLineParamsValidator, drawRectangleValidator, drawBucketFillParamsValidator);
  }

  @Test
  void shouldValidateDrawLineParams() {
    String command = "L";
    String[] params = {"1", "2", "3", "4"};
    paramsValidator.validate(command, params);
    verify(drawLineParamsValidator).validate(params);
    verifyNoMoreInteractions(createCanvasParamsValidator, drawRectangleValidator, drawBucketFillParamsValidator);
  }

  @Test
  void shouldValidateDrawRectangleParams() {
    String command = "R";
    String[] params = {"1", "2", "3", "4"};
    paramsValidator.validate(command, params);
    verify(drawRectangleValidator).validate(params);
    verifyNoMoreInteractions(createCanvasParamsValidator, drawLineParamsValidator, drawBucketFillParamsValidator);
  }

  @Test
  void shouldValidateDrawBucketFillParams() {
    String command = "B";
    String[] params = {"1", "2", "c"};
    paramsValidator.validate(command, params);
    verify(drawBucketFillParamsValidator).validate(params);
    verifyNoMoreInteractions(createCanvasParamsValidator, drawLineParamsValidator, drawRectangleValidator);
  }

}
