package com.springbootdrawingapp.mapper;

import com.springbootdrawingapp.commands.*;
import com.springbootdrawingapp.enums.Commands;
import com.springbootdrawingapp.utils.validator.CommandValidator;
import com.springbootdrawingapp.utils.validator.ParamsValidator;

public class CommandMapper {
  private final CommandValidator commandValidator = new CommandValidator();
  private final ParamsValidator paramsValidator = new ParamsValidator();
  private final CommandsMapper commandsMapper = new CommandsMapper();

  public Command createCommand(String commandString, String[] params) {
    Commands command = commandsMapper.stringToCommands(commandString);

      commandValidator.validate(commandString);
      paramsValidator.validate(commandString, params);

      return switch (command) {
        case CREATE_CANVAS -> new CreateCanvasCommand(params);
        case NEW_LINE -> new DrawLineCommand(params);
        case NEW_RECTANGLE -> new DrawRectangleCommand();
        case FILL_AREA -> new FloodFillCommand();
        case QUIT -> new QuitCommand();
    };
  }
}
