package com.springbootdrawingapp.utils;

import com.drawingprogram.exceptions.OutOfBoundsException;
import com.springbootdrawingapp.commands.DrawLineCommand;
import com.springbootdrawingapp.enums.CanvasChar;
import com.springbootdrawingapp.enums.CommandError;

public class LineUtil {
  public void draw(DrawLineCommand command, char[][] canvasArray) {
    if (command.getX1() > canvasArray[0].length || command.getY1() > canvasArray.length) {
      throw new OutOfBoundsException(CommandError.OUT_OF_BOUNDS.toString());
    }
    drawLine(command.getX1(), command.getY1(), command.getX2(),
        command.getY2(), canvasArray);
  }

  private void drawLine(int x1, int y1, int x2, int y2, char[][] canvasArray) {

    int height = Math.min(canvasArray.length, y2);
    int width = Math.min(canvasArray[0].length, x2);

    for (int row = y1 - 1; row < y2 && row < height; row++) {
      for (int col = x1 - 1; col < x2 && col < width; col++) {
        canvasArray[col][row] = CanvasChar.LINE.toChar();
      }
    }
  }
}
