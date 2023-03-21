package com.springbootdrawingapp.utils.drawing;

import com.springbootdrawingapp.commands.DrawBucketFillCommand;
import com.springbootdrawingapp.enums.CommandError;
import com.springbootdrawingapp.exceptions.OutOfBoundsException;
import org.springframework.stereotype.Service;

@Service
public class BucketFillUtil {
  private final DrawBucketFillCommand drawBucketFillCommand;

  public BucketFillUtil(DrawBucketFillCommand drawBucketFillCommand) {
    this.drawBucketFillCommand = drawBucketFillCommand;
  }

  public void draw(char[][] canvasArray) {
    if (drawBucketFillCommand.getY1() > canvasArray[0].length || drawBucketFillCommand.getX1() > canvasArray.length) {
      throw new OutOfBoundsException(CommandError.OUT_OF_BOUNDS.toString());
    }

    int x = drawBucketFillCommand.getX1() - 1;
    int y = drawBucketFillCommand.getY1() - 1;
    char fillChar = drawBucketFillCommand.getFillChar();
    char sourceChar = canvasArray[y][x];

    int height = canvasArray.length;
    int width = canvasArray[0].length;

    fillHelper(canvasArray, x, y, width, height, sourceChar, fillChar);

  }

  void fillHelper(char[][] screen, int x, int y, int width, int height, char prevC, char newC) {
    if (x < 0 || x >= width || y < 0 || y >= height)
      return;
    if (screen[y][x] != prevC)
      return;

    screen[y][x] = newC;

    fillHelper(screen, x + 1, y, width, height, prevC, newC);
    fillHelper(screen, x - 1, y, width, height, prevC, newC);
    fillHelper(screen, x, y + 1, width, height, prevC, newC);
    fillHelper(screen, x, y - 1, width, height, prevC, newC);
  }
}
