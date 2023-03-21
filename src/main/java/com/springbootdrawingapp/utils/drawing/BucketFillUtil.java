package com.springbootdrawingapp.utils.drawing;

import com.springbootdrawingapp.commands.DrawBucketFillCommand;
import com.springbootdrawingapp.enums.CommandError;
import com.springbootdrawingapp.exceptions.OutOfBoundsException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BucketFillUtil {

  public void draw(DrawBucketFillCommand command, char[][] canvasArray) {
    if (command.getY1() > canvasArray[0].length || command.getX1() > canvasArray.length) {
      throw new OutOfBoundsException(CommandError.OUT_OF_BOUNDS.toString());
    }

    System.out.println(Arrays.deepToString(canvasArray));

    int x = command.getX1() - 1;
    int y = command.getY1() - 1;
    char fillChar = command.getFillChar();
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
