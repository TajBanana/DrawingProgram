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
    if (command instanceof QuitCommand) {
      ((QuitCommand) command).execute();
    }
    else if (command instanceof CreateCanvasCommand) {
      canvasRectangle.construct();
    }
    else if (canvasRectangle.getCanvasArray() == null) {
      throw new EmptyCanvasException();
    }
    else if (command instanceof DrawCommand) {
      canvasRectangle.addEntity((DrawCommand) command);
    }

  }
}
