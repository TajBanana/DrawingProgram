package com.springbootdrawingapp;

import com.springbootdrawingapp.exceptions.EmptyCanvasException;
import com.springbootdrawingapp.commands.*;
import com.springbootdrawingapp.factory.CommandFactory;
import com.springbootdrawingapp.models.Canvas;
import com.springbootdrawingapp.models.CanvasRectangle;
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

    if (command.getClass().equals(CreateCanvasCommand.class)) {
      int width = ((CreateCanvasCommand) command).getWidth();
      int height = ((CreateCanvasCommand) command).getHeight();
      canvas = new CanvasRectangle(width, height);
    }
    else if (canvas == null) {
      throw new EmptyCanvasException();
    }
    else if (command.getClass().equals(DrawLineCommand.class)) {
      canvas.addEntity((DrawLineCommand) command);
    }
    else if (command.getClass().equals(DrawRectangleCommand.class)) {
      canvas.addEntity((DrawRectangleCommand) command);
    }
    else if (command.getClass().equals(DrawBucketFillCommand.class)) {
      canvas.addEntity((DrawBucketFillCommand) command);
    }
  }
}
