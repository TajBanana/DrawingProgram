/*
package com.springbootdrawingapp.utils.drawing;

import com.springbootdrawingapp.commands.DrawLineCommand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class LineUtilDrawLineTest {

  @Mock
  LineUtil lineUtil;

  @Mock
  DrawLineCommand drawLineCommand;

  private char[][] canvasArray = new char[10][10];

  @Test
  void testDrawLine() {
    lineUtil.draw(drawLineCommand, canvasArray);
    verify(lineUtil).drawLine(drawLineCommand.getX1(),
        drawLineCommand.getY1(), drawLineCommand.getX2(),
        drawLineCommand.getY2(), canvasArray);
  }

}
*/
