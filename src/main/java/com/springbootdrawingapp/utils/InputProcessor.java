package com.springbootdrawingapp.utils;

import com.drawingprogram.exceptions.EmptyCanvasException;
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
    Command command;

    try {
      command = commandFactory.getCommand(inputString);
      execute(command);

    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }
  }

  public void execute(Command command) {

    if (command instanceof CreateCanvasCommand) {
      int width = ((CreateCanvasCommand) command).getWidth();
      int height = ((CreateCanvasCommand) command).getHeight();

      canvas = new RectCanvas(width, height);
    }

    if (canvas == null) throw new EmptyCanvasException();

    if (command instanceof DrawLineCommand) {
      canvas.addEntity((DrawLineCommand) command);
    }
    if (command instanceof DrawRectangleCommand) {
      canvas.render();
    }
    if (command instanceof FloodFillCommand) {
      canvas.render();
    }
  }
}
