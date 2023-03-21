package com.springbootdrawingapp.utils.drawing;

import com.springbootdrawingapp.commands.DrawBucketFillCommand;
import com.springbootdrawingapp.exceptions.OutOfBoundsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BucketFillUtilTest {

  @InjectMocks
  BucketFillUtil bucketFillUtil;


  @Test
  public void testDrawWithValidInput() {
    DrawBucketFillCommand command = mock(DrawBucketFillCommand.class);
    when(command.getX1()).thenReturn(2);
    when(command.getY1()).thenReturn(3);
    when(command.getFillChar()).thenReturn('c');

    char[][] canvasArray = {{'o', 'o', 'o', 'o', 'o'}, {'o', 'o', 'o', 'o', 'o'}, {'o', 'o', 'o', 'o', 'o'}};

    bucketFillUtil.draw(command, canvasArray);

    assertEquals('c', canvasArray[1][2]);
  }

  @Test
  public void testDrawWithInvalidXInput() {
    DrawBucketFillCommand command = mock(DrawBucketFillCommand.class);
    when(command.getX1()).thenReturn(4);
    when(command.getY1()).thenReturn(1);

    char[][] canvasArray = {{'o', 'o', 'o', 'o', 'o'}, {'o', 'o', 'o', 'o', 'o'}, {'o', 'o', 'o', 'o', 'o'}};

    assertThrows(OutOfBoundsException.class, () -> bucketFillUtil.draw(command, canvasArray));
  }

  @Test
  public void testDrawWithInvalidYInput() {
    DrawBucketFillCommand command = mock(DrawBucketFillCommand.class);
    when(command.getY1()).thenReturn(6);

    char[][] canvasArray = {{'o', 'o', 'o', 'o', 'o'}, {'o', 'o', 'o', 'o', 'o'}, {'o', 'o', 'o', 'o', 'o'}};

    assertThrows(OutOfBoundsException.class, () -> bucketFillUtil.draw(command, canvasArray));
  }

}
