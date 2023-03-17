package com.drawingprogram.factory;

import com.drawingprogram.enums.CanvasChar;

import java.util.Collections;

public class CanvasFactory {
  public static String rectangle(int width, int height, char[][] canvasArray) {
    String horizontalEdge = String.join("", Collections.nCopies(width + 2,
        String.valueOf(CanvasChar.HORIZONTAL)));
    StringBuilder builder = new StringBuilder();

    builder.append(horizontalEdge).append("\n");

    for (int row = 0; row < height; row++) {
      builder.append(CanvasChar.VERTICAL);

      for (int column = 0; column < width; column++) {
        builder.append(canvasArray[column][row]);
      }
      builder.append(CanvasChar.VERTICAL);
      builder.append("\n");
    }
    builder.append(horizontalEdge);
    return builder.toString();
  }
}
