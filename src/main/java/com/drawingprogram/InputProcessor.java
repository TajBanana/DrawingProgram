package com.drawingprogram;

import com.drawingprogram.commands.*;
import com.drawingprogram.factory.CommandFactory;
import com.drawingprogram.models.Canvas;
import com.drawingprogram.models.RectCanvas;

public class InputProcessor {
  private static Canvas canvas;

  public void process(String inputString) {
    final CommandFactory commandFactory = new CommandFactory();

    Command command = null;

    try {
      command = commandFactory.getCommand(inputString);
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }

    execute(command);
  }

  private void execute(Command command) {
    if (command instanceof CreateCanvasCommand) {
      int width = ((CreateCanvasCommand) command).getWidth();
      int height = ((CreateCanvasCommand) command).getHeight();

      canvas = new RectCanvas(width, height);
      canvas.render();
    }
    if (command instanceof DrawLineCommand) {
    }
    if (command instanceof DrawRectangleCommand) {
    }
    if (command instanceof FloodFillCommand) {
    }
  }
}
