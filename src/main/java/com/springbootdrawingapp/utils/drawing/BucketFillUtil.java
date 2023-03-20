package com.springbootdrawingapp.utils.drawing;

import com.springbootdrawingapp.commands.DrawBucketFillCommand;
import com.springbootdrawingapp.enums.CommandError;
import com.springbootdrawingapp.exceptions.OutOfBoundsException;
import org.springframework.stereotype.Service;

@Service
public class BucketFillUtil {

  public void fill(DrawBucketFillCommand command, char[][] canvasArray) {
    if (command.getY1() > canvasArray[0].length || command.getX1() > canvasArray.length) {
      throw new OutOfBoundsException(CommandError.OUT_OF_BOUNDS.toString());
    }

    int xIndex = command.getX1() - 1;
    int yIndex = command.getY1() - 1;
    char fillChar = command.getFillChar();
    char sourceChar = canvasArray[xIndex][yIndex];

    int height = canvasArray.length;
    int row = canvasArray[0].length;

    fillHelper(canvasArray, xIndex, yIndex, height, row, sourceChar, fillChar);

  }

  private void fillHelper(char[][] canvasArray, int sr, int sc,
                          int column, int row, char sourceChar, char fillChar) {
// Condition for checking out of bounds
    if (sr < 0 || sr >= column || sc < 0 || sc >= row)
      return;

    if (canvasArray[sr][sc] != sourceChar)
      return;

    canvasArray[sr][sc] = fillChar;
    fillHelper(canvasArray, sr - 1, sc, column, row, sourceChar, fillChar); // left
    fillHelper(canvasArray, sr + 1, sc, column, row, sourceChar, fillChar); // right
    fillHelper(canvasArray, sr, sc + 1, column, row, sourceChar, fillChar); // top
    fillHelper(canvasArray, sr, sc - 1, column, row, sourceChar, fillChar); // bottom
  }
}
