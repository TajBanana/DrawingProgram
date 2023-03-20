package com.springbootdrawingapp;

import com.springbootdrawingapp.exceptions.EmptyCanvasException;
import com.springbootdrawingapp.commands.*;
import com.springbootdrawingapp.factory.CommandFactory;
import com.springbootdrawingapp.models.CanvasRectangle;
import org.springframework.stereotype.Component;

@Component
public class InputProcessor {
  private final CommandFactory commandFactory;
  private final CanvasRectangle canvasRectangle;

  public InputProcessor(CommandFactory commandFactory, CanvasRectangle canvasRectangle) {
    this.commandFactory = commandFactory;
    this.canvasRectangle = canvasRectangle;
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
      canvasRectangle.setHeight(height);
      canvasRectangle.setWidth(width);
      canvasRectangle.constructProperty();
    }
    else if (canvasRectangle.getCanvasArray() == null) {
      throw new EmptyCanvasException();
    }
    else if (command.getClass().equals(DrawLineCommand.class)) {
      canvasRectangle.addEntity((DrawLineCommand) command);
    }
    else if (command.getClass().equals(DrawRectangleCommand.class)) {
      canvasRectangle.addEntity((DrawRectangleCommand) command);
    }
    else if (command.getClass().equals(DrawBucketFillCommand.class)) {
      canvasRectangle.addEntity((DrawBucketFillCommand) command);
    }
  }
}
