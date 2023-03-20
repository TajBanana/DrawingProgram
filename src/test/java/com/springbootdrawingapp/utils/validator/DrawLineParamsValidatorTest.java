package com.springbootdrawingapp.utils.validator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import com.springbootdrawingapp.exceptions.InvalidLineParamsException;
import com.springbootdrawingapp.exceptions.NotImplementedException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DrawLineParamsValidatorTest {

  @Mock
  private PositiveNumberValidator positiveNumberValidatorMock;

  @InjectMocks
  private DrawLineParamsValidator validator;

  @Test
  public void testValidate_InvalidParamsLength() {
    String[] params = new String[]{"1", "2", "3"};
    assertThrows(InvalidLineParamsException.class, () -> validator.validate(params));
  }

  @Test
  public void testValidate_DiagonalLine() {
    String[] params = new String[]{"1", "1", "2", "2"};
    assertThrows(NotImplementedException.class, () -> validator.validate(params));
  }

  @Test
  public void testValidate_ValidParams() {
    String[] params = new String[]{"1", "2", "1", "4"};
    validator.validate(params);
    verify(positiveNumberValidatorMock, times(4)).validate(anyString());
  }

}
