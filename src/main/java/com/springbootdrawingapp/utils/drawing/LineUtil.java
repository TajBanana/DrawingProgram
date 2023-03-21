package com.springbootdrawingapp.utils.drawing;

import com.springbootdrawingapp.exceptions.OutOfBoundsException;
import com.springbootdrawingapp.commands.DrawLineCommand;
import com.springbootdrawingapp.enums.CanvasChar;
import com.springbootdrawingapp.enums.CommandError;
import org.springframework.stereotype.Service;

@Service
public class LineUtil {
  private final DrawLineCommand drawLineCommand;

  public LineUtil(DrawLineCommand drawLineCommand) {
    this.drawLineCommand = drawLineCommand;
  }

  public void draw(char[][] canvasArray) {
    if (drawLineCommand.getX1() > canvasArray[0].length || drawLineCommand.getY1() > canvasArray.length) {
      throw new OutOfBoundsException(CommandError.OUT_OF_BOUNDS.toString());
    }
    drawLine(drawLineCommand.getX1(), drawLineCommand.getY1(), drawLineCommand.getX2(),
        drawLineCommand.getY2(), canvasArray);
  }

  public void drawLine(int x1, int y1, int x2, int y2, char[][] canvasArray) {
    int height = Math.min(canvasArray.length, y2);
    int width = Math.min(canvasArray[0].length, x2);

    for (int row = y1 - 1; row <= height - 1; row++) {
      for (int column = x1 - 1; column <= width - 1; column++) {
        canvasArray[row][column] = CanvasChar.LINE.toChar();
      }
    }
  }
}
