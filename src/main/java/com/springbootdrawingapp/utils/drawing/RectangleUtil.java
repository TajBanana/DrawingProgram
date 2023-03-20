package com.springbootdrawingapp.utils.drawing;

import com.springbootdrawingapp.commands.DrawRectangleCommand;
import com.springbootdrawingapp.enums.CommandError;
import com.springbootdrawingapp.exceptions.OutOfBoundsException;
import org.springframework.stereotype.Service;

@Service
public class RectangleUtil {
  private final LineUtil lineUtil;

  public RectangleUtil(LineUtil lineUtil) {
    this.lineUtil = lineUtil;
  }

  public void draw(DrawRectangleCommand command, char[][] canvasArray) {
    if (command.getX1() > canvasArray[0].length || command.getY1() > canvasArray.length) {
      throw new OutOfBoundsException(CommandError.OUT_OF_BOUNDS.toString());
    }

    drawRectangle(command.getX1(), command.getY1(), command.getX2(),
        command.getY2(), canvasArray);
  }

  private void drawRectangle(int x1, int y1, int x2, int y2, char[][] canvasArray) {
    lineUtil.drawLine(x1, y1, x2, y1,canvasArray);
    lineUtil.drawLine(x1, y1, x1, y2,canvasArray);
    lineUtil.drawLine(x2, y1, x2, y2,canvasArray);
    lineUtil.drawLine(x1, y2, x2, y2,canvasArray);

  }
}
