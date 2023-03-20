package com.springbootdrawingapp.utils.drawing;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.springbootdrawingapp.commands.DrawLineCommand;
import com.springbootdrawingapp.enums.CanvasChar;
import com.springbootdrawingapp.exceptions.OutOfBoundsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LineUtilTest {

  @InjectMocks
  private LineUtil lineUtil;
  private char[][] canvasArray;

  @BeforeEach
  public void setUp() {
    canvasArray = new char[10][10];
  }

  @Test
  public void testDrawLine() {
    lineUtil.drawLine(1, 1, 5, 1, canvasArray);

    for (int i = 0; i < 5; i++) {
      assertEquals(CanvasChar.LINE.toChar(), canvasArray[0][i]);
    }
  }

  @Test
  public void testDrawLineOutOfBounds() {
    assertThrows(OutOfBoundsException.class, () -> {
      String[] params = new String[]{"20", "1", "20", "1"};
      DrawLineCommand drawLineCommand = new DrawLineCommand(params);
      lineUtil.draw(drawLineCommand, canvasArray);
    });
  }

  @Test
  public void testDrawLineMock() {
    DrawLineCommand command = mock(DrawLineCommand.class);
    when(command.getX1()).thenReturn(1);
    when(command.getY1()).thenReturn(1);
    when(command.getX2()).thenReturn(5);
    when(command.getY2()).thenReturn(1);

    lineUtil.draw(command, canvasArray);

    for (int i = 0; i < 5; i++) {
      assertEquals(CanvasChar.LINE.toChar(), canvasArray[0][i]);
    }
  }

}
