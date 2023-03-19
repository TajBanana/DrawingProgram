package com.springbootdrawingapp.utils;

import com.springbootdrawingapp.commands.*;
import com.springbootdrawingapp.factory.CommandFactory;
import com.springbootdrawingapp.models.Canvas;
import com.springbootdrawingapp.models.RectCanvas;
import org.springframework.stereotype.Component;

@Component
public class InputProcessor {
  private static Canvas canvas;
  private final CommandFactory commandFactory;

  public InputProcessor(CommandFactory commandFactory) {
    this.commandFactory = commandFactory;
  }

  public void process(String inputString) {
    Command command = null;

    try {
      command = commandFactory.getCommand(inputString);
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }

    execute(command);
  }

  public void execute(Command command) {
    if (command instanceof DrawCanvasCommand) {
      int width = ((DrawCanvasCommand) command).getWidth();
      int height = ((DrawCanvasCommand) command).getHeight();

      canvas = new RectCanvas(width, height);
      canvas.render();
    }
    if (command instanceof DrawLineCommand) {
      System.out.println(command);
      canvas.render();
    }
    if (command instanceof DrawRectangleCommand) {
      canvas.render();
    }
    if (command instanceof FloodFillCommand) {
      canvas.render();
    }
  }
}
