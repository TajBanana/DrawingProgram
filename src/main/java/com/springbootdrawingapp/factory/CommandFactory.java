package com.springbootdrawingapp.factory;

import com.springbootdrawingapp.commands.*;
import com.springbootdrawingapp.enums.Commands;
import com.springbootdrawingapp.mapper.CommandsMapper;
import com.springbootdrawingapp.utils.validator.CommandValidator;
import com.springbootdrawingapp.utils.validator.ParamsValidator;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CommandFactory {
  private final CommandValidator commandValidator;
  private final ParamsValidator paramsValidator;
  private final CommandsMapper commandsMapper;

  public CommandFactory(
      CommandValidator commandValidator,
      ParamsValidator paramsValidator,
      CommandsMapper commandsMapper) {
    this.commandValidator = commandValidator;
    this.paramsValidator = paramsValidator;
    this.commandsMapper = commandsMapper;
  }

  public Command getCommand(String userInput) {
    String[] inputArray = userInput.split("\\s+");
    String commandString = inputArray[0];
    String[] params = Arrays.copyOfRange(inputArray, 1,
        inputArray.length);

    return createCommand(commandString, params);
  }

  public Command createCommand(String commandString, String[] params) {
    Commands command = commandsMapper.stringToCommands(commandString);

    commandValidator.validate(commandString);
    paramsValidator.validate(commandString, params);

    return switch (command) {
      case CREATE_CANVAS -> new DrawCanvasCommand(params);
      case NEW_LINE -> new DrawLineCommand(params);
      case NEW_RECTANGLE -> new DrawRectangleCommand();
      case FILL_AREA -> new FloodFillCommand();
      case QUIT -> new QuitCommand();
    };
  }
}
