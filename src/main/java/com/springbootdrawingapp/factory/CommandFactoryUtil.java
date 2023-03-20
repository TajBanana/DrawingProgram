package com.springbootdrawingapp.factory;

import com.springbootdrawingapp.commands.*;
import com.springbootdrawingapp.enums.Commands;
import org.springframework.stereotype.Service;

@Service
public class CommandFactoryUtil {
  public Command resolve(Commands command, String[] params) {

    return switch (command) {
      case CREATE_CANVAS -> new CreateCanvasCommand(params);
      case NEW_LINE -> new DrawLineCommand(params);
      case NEW_RECTANGLE -> new DrawRectangleCommand(params);
      case FILL_AREA -> new DrawBucketFillCommand(params);
      case QUIT -> new QuitCommand();
    };
  }
}

