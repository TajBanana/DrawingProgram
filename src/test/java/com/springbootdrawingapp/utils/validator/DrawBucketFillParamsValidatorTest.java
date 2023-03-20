package com.springbootdrawingapp.utils.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import com.springbootdrawingapp.exceptions.InvalidFillArgumentException;
import com.springbootdrawingapp.exceptions.InvalidLineParamsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DrawBucketFillParamsValidatorTest {

  @Mock
  private PositiveNumberValidator positiveNumberValidatorMock;

  @InjectMocks
  private DrawBucketFillParamsValidator validator;

  @Test
  public void testValidate_InvalidParamsLength() {
    String[] params = new String[]{"1", "2"};
    assertThrows(InvalidLineParamsException.class, () -> validator.validate(params));
  }

  @Test
  public void testValidate_InvalidFillArgument() {
    String[] params = new String[]{"1", "2", "abc"};
    assertThrows(InvalidFillArgumentException.class, () -> validator.validate(params));
  }

  @Test
  public void testValidate_ValidParams() {
    String[] params = new String[]{"1", "2", "a"};
    validator.validate(params);
    verify(positiveNumberValidatorMock, times(2)).validate(anyString());
  }

}
