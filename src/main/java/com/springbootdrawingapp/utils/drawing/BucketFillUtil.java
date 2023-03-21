package com.springbootdrawingapp.utils.drawing;

import com.springbootdrawingapp.commands.DrawBucketFillCommand;
import com.springbootdrawingapp.enums.CommandError;
import com.springbootdrawingapp.exceptions.OutOfBoundsException;
import org.springframework.stereotype.Service;

@Service
public class BucketFillUtil {

  public void draw(DrawBucketFillCommand command, char[][] canvasArray) {
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

  private void fillHelper(char[][] canvasArray, int searchRow, int searchColumn,
                          int column, int row, char sourceChar, char fillChar) {
    if (searchRow < 0 || searchRow >= column || searchColumn < 0 || searchColumn >= row)
      return;

    if (canvasArray[searchRow][searchColumn] != sourceChar)
      return;

    canvasArray[searchRow][searchColumn] = fillChar;
    fillHelper(canvasArray, searchRow - 1, searchColumn, column, row, sourceChar, fillChar); // left
    fillHelper(canvasArray, searchRow + 1, searchColumn, column, row, sourceChar, fillChar); // right
    fillHelper(canvasArray, searchRow, searchColumn + 1, column, row, sourceChar, fillChar); // top
    fillHelper(canvasArray, searchRow, searchColumn - 1, column, row, sourceChar, fillChar); // bottom
  }
}
