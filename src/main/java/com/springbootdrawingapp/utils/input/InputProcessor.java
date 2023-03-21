package com.springbootdrawingapp.utils.input;

import com.springbootdrawingapp.commands.*;
import com.springbootdrawingapp.factory.CommandFactory;
import com.springbootdrawingapp.utils.validator.ParamsValidator;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class InputProcessor {
  private final CommandFactory commandFactory;
  private final InputExecutor inputExecutor;
  private final ParamsValidator paramsValidator;

  public InputProcessor(CommandFactory commandFactory,
                        InputExecutor inputExecutor,
                        ParamsValidator paramsValidator) {
    this.commandFactory = commandFactory;
    this.inputExecutor = inputExecutor;
    this.paramsValidator = paramsValidator;
  }

  public void process(String inputString) {

    String[] inputArray = inputString.split("\\s+");
    String commandString = inputArray[0];
    String[] params = Arrays.copyOfRange(inputArray, 1,
        inputArray.length);

    try {
      Command command = commandFactory.getCommand(commandString);
      paramsValidator.validate(commandString, params);
      command.setParams(params);
      inputExecutor.execute(command);

    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }
  }
}
