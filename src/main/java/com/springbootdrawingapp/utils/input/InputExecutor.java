package com.springbootdrawingapp.utils.input;

import com.springbootdrawingapp.commands.*;
import com.springbootdrawingapp.exceptions.EmptyCanvasException;
import com.springbootdrawingapp.models.CanvasRectangle;
import org.springframework.stereotype.Service;

@Service
public class InputExecutor {
  private final CanvasRectangle canvasRectangle;

  public InputExecutor(CanvasRectangle canvasRectangle) {
    this.canvasRectangle = canvasRectangle;
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
