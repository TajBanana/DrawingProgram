package com.springbootdrawingapp;

import com.springbootdrawingapp.commands.*;
import com.springbootdrawingapp.factory.CommandFactory;
import com.springbootdrawingapp.utils.InputExecutor;
import org.springframework.stereotype.Component;

@Component
public class InputProcessor {
  private final CommandFactory commandFactory;
  private final InputExecutor inputExecutor;

  public InputProcessor(CommandFactory commandFactory, InputExecutor inputExecutor) {
    this.commandFactory = commandFactory;
    this.inputExecutor = inputExecutor;
  }

  public void process(String inputString) {
    Command command;

    try {
      command = commandFactory.getCommand(inputString);
      inputExecutor.execute(command);

    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }
  }
}
