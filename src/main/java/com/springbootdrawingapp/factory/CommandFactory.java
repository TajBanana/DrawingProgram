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
  private final CommandFactoryUtil commandFactoryUtil;

  public CommandFactory(
      CommandValidator commandValidator,
      ParamsValidator paramsValidator,
      CommandsMapper commandsMapper,
      CommandFactoryUtil commandFactoryUtil) {
    this.commandValidator = commandValidator;
    this.paramsValidator = paramsValidator;
    this.commandsMapper = commandsMapper;
    this.commandFactoryUtil = commandFactoryUtil;
  }

  public Command getCommand(String userInput) {
    String[] inputArray = userInput.split("\\s+");
    String commandString = inputArray[0];
    String[] params = Arrays.copyOfRange(inputArray, 1,
        inputArray.length);

    return createCommand(commandString, params);
  }

  public Command createCommand(String commandString, String[] params) {

    commandValidator.validate(commandString);
    paramsValidator.validate(commandString, params);

    Commands command = commandsMapper.stringToCommands(commandString);

    return commandFactoryUtil.resolve(command, params);
  }
}
