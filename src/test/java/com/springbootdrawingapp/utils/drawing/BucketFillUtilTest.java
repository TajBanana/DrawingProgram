package com.springbootdrawingapp.utils.drawing;

import com.springbootdrawingapp.commands.DrawBucketFillCommand;
import com.springbootdrawingapp.exceptions.OutOfBoundsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BucketFillUtilTest {

  @Mock
  private DrawBucketFillCommand drawBucketFillCommand;

  @InjectMocks
  BucketFillUtil bucketFillUtil;


  @Test
  public void testDrawWithValidInput() {
    when(drawBucketFillCommand.getX1()).thenReturn(2);
    when(drawBucketFillCommand.getY1()).thenReturn(3);
    when(drawBucketFillCommand.getFillChar()).thenReturn('c');


    char[][] canvasArray = {{'o', 'o', 'o', 'o', 'o'}, {'o', 'o', 'o', 'o', 'o'}, {'o', 'o', 'o', 'o', 'o'}};

    bucketFillUtil.draw(canvasArray);

    assertEquals('c', canvasArray[1][2]);
  }

  @Test
  public void testDrawWithInvalidXInput() {
    when(drawBucketFillCommand.getX1()).thenReturn(4);
    when(drawBucketFillCommand.getY1()).thenReturn(1);

    char[][] canvasArray = {{'o', 'o', 'o', 'o', 'o'}, {'o', 'o', 'o', 'o', 'o'}, {'o', 'o', 'o', 'o', 'o'}};

    assertThrows(OutOfBoundsException.class, () -> bucketFillUtil.draw(canvasArray));
  }

  @Test
  public void testDrawWithInvalidYInput() {
    when(drawBucketFillCommand.getY1()).thenReturn(6);

    char[][] canvasArray = {{'o', 'o', 'o', 'o', 'o'}, {'o', 'o', 'o', 'o', 'o'}, {'o', 'o', 'o', 'o', 'o'}};

    assertThrows(OutOfBoundsException.class, () -> bucketFillUtil.draw(canvasArray));
  }

}
