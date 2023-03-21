package com.springbootdrawingapp.utils.drawing;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import com.springbootdrawingapp.commands.DrawLineCommand;
import com.springbootdrawingapp.enums.CanvasChar;
import com.springbootdrawingapp.exceptions.OutOfBoundsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LineUtilTest {

  @InjectMocks
  private LineUtil lineUtil;

  @Mock
  private DrawLineCommand drawLineCommand;

  private char[][] canvasArray;

  @BeforeEach
  public void setup() {
    lineUtil = new LineUtil();
    drawLineCommand = mock(DrawLineCommand.class);
    canvasArray = new char[10][10];
  }

  @Test
  public void testDrawLine() {
    int x1 = 1;
    int y1 = 1;
    int x2 = 5;
    int y2 = 5;

    lineUtil.drawLine(x1, y1, x2, y2, canvasArray);

    for (int row = y1 - 1; row <= y2 - 1; row++) {
      for (int column = x1 - 1; column <= x2 - 1; column++) {
        assert(canvasArray[row][column] == CanvasChar.LINE.toChar());
      }
    }
  }

  @Test
  public void testDraw() {
     DrawLineCommand command = new DrawLineCommand();
     String[] params = new String[] {"1", "1", "5", "5"};
     command.setParams(params);

    lineUtil.draw(command, canvasArray);

    for (int row = 0; row <= 4; row++) {
      for (int column = 0; column <= 4; column++) {
        assert(canvasArray[row][column] == CanvasChar.LINE.toChar());
      }
    }
  }

  @Test
  public void testXDrawOutOfBounds() {
    when(drawLineCommand.getX1()).thenReturn(11);
    assertThrows(OutOfBoundsException.class, () -> lineUtil.draw(drawLineCommand, canvasArray));
  }

  @Test
  public void testYDrawOutOfBounds() {
    when(drawLineCommand.getY1()).thenReturn(11);
    assertThrows(OutOfBoundsException.class, () -> lineUtil.draw(drawLineCommand, canvasArray));
  }
}