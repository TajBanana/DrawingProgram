package com.drawingprogram;

import com.drawingprogram.commands.*;
import com.drawingprogram.factory.CommandFactory;
import com.drawingprogram.models.Canvas;
import com.drawingprogram.models.RectCanvas;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InputProcessor {
  private final CommandFactory commandFactory;
  private static Canvas canvas;

  public InputProcessor(CommandFactory commandFactory) {
    this.commandFactory = commandFactory;
  }

  public void process(String inputString) {
    Command command = null;

    try {
      command = commandFactory.getCommand(inputString);
    } catch (RuntimeException e) {
      log.error(e.getMessage());
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
