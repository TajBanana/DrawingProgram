package com.drawingprogram.factory;

import com.drawingprogram.commands.Command;
import com.drawingprogram.mapper.CommandMapper;

import java.util.Arrays;

public class CommandFactory {
  private final CommandMapper commandMapper = new CommandMapper();

  public Command getCommand(String userInput) {
    String[] inputArray = userInput.split("\\s+");
    String commandString = inputArray[0];
    String[] params = Arrays.copyOfRange(inputArray, 1,
        inputArray.length);

    return commandMapper.createCommand(commandString, params);
  }

}
