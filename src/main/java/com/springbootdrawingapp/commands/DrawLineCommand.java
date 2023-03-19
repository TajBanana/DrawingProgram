package com.springbootdrawingapp.commands;

import java.util.Arrays;

public class DrawLineCommand implements Command {
  private final String[] params;

  public DrawLineCommand(String[] params) {
    this.params = params;
  }

  @Override
  public String toString() {
    return "DrawLineCommand{" +
        "params=" + Arrays.toString(params) +
        '}';
  }
}
