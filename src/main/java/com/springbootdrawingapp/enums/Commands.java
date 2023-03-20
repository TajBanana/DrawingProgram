package com.springbootdrawingapp.enums;

public enum Commands {
  CREATE_CANVAS ("C"),
  NEW_LINE ("L"),
  NEW_RECTANGLE ("R"),
  FILL_AREA ("B"),
  QUIT ("Q");

  private final String inputString;

  Commands(String inputCommand) {
    this.inputString = inputCommand;
  }

  public String inputString() {
    return inputString;
  }
}
