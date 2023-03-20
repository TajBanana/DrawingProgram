package com.springbootdrawingapp.factory;

import com.springbootdrawingapp.commands.*;
import com.springbootdrawingapp.exceptions.InvalidCommandException;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class CommandFactory {
  private final CreateCanvasCommand createCanvasCommand;
  private final DrawLineCommand drawLineCommand;
  private final DrawRectangleCommand drawRectangleCommand;
  private final DrawBucketFillCommand drawBucketFillCommand;
  private final QuitCommand quitCommand;

  public CommandFactory(CreateCanvasCommand createCanvasCommand,
                        DrawLineCommand drawLineCommand,
                        DrawRectangleCommand drawRectangleCommand,
                        DrawBucketFillCommand drawBucketFillCommand,
                        QuitCommand quitCommand) {
    this.createCanvasCommand = createCanvasCommand;
    this.drawLineCommand = drawLineCommand;
    this.drawRectangleCommand = drawRectangleCommand;
    this.drawBucketFillCommand = drawBucketFillCommand;
    this.quitCommand = quitCommand;
  }

  public Command getCommand(String commandString) {
    return switch (commandString.toUpperCase()) {
      case "C" -> createCanvasCommand;
      case "L" -> drawLineCommand;
      case "R" -> drawRectangleCommand;
      case "B" -> drawBucketFillCommand;
      case "Q" -> quitCommand;
      default -> throw new InvalidCommandException();
    };
  }
}

