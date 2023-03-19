package com.springbootdrawingapp.utils;

import com.springbootdrawingapp.commands.*;
import com.springbootdrawingapp.factory.CommandFactory;
import com.springbootdrawingapp.models.Canvas;
import com.springbootdrawingapp.models.RectCanvas;
import org.springframework.stereotype.Component;

@Component
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
      System.out.println(command);
    }
    if (command instanceof DrawRectangleCommand) {
    }
    if (command instanceof FloodFillCommand) {
    }
  }
}
