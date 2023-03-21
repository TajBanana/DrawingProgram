package com.springbootdrawingapp.utils.drawing;

import com.springbootdrawingapp.commands.DrawRectangleCommand;
import com.springbootdrawingapp.exceptions.OutOfBoundsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RectangleUtilTest {

  @Mock
  private LineUtil lineUtil;

  @InjectMocks
  private RectangleUtil rectangleUtil;

  @Test
  void testXOutOfBoundsException() {
    DrawRectangleCommand drawRectangleCommand = new DrawRectangleCommand();
    char[][] canvasArray = new char[5][5];
    String[] params = {"6", "1", "6", "1"};
    drawRectangleCommand.setParams(params);

    assertThrows(OutOfBoundsException.class,
        () -> rectangleUtil.draw(canvasArray));
  }

  @Test
  void testYOutOfBoundsException() {
    DrawRectangleCommand drawRectangleCommand = new DrawRectangleCommand();
    char[][] canvasArray = new char[5][5];
    String[] params = {"1", "6", "1", "6"};
    drawRectangleCommand.setParams(params);

    assertThrows(OutOfBoundsException.class,
        () -> rectangleUtil.draw(canvasArray));
  }


  @Test
  void testDraw() {
    DrawRectangleCommand drawRectangleCommand = mock(DrawRectangleCommand.class);
    char[][] canvasArray = new char[5][5];
    when(drawRectangleCommand.getX1()).thenReturn(1);
    when(drawRectangleCommand.getY1()).thenReturn(2);
    when(drawRectangleCommand.getX2()).thenReturn(3);
    when(drawRectangleCommand.getY2()).thenReturn(4);

    rectangleUtil.draw(canvasArray);

    verify(lineUtil, times(1)).drawLine(1, 2, 3, 2, canvasArray);
    verify(lineUtil, times(1)).drawLine(1, 2, 1, 4, canvasArray);
    verify(lineUtil, times(1)).drawLine(3, 2, 3, 4, canvasArray);
    verify(lineUtil, times(1)).drawLine(1, 4, 3, 4, canvasArray);
  }
}
