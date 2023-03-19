package com.springbootdrawingapp.enums;

public enum CommandError {
  INVALID_COMMAND("""

      \u001B[31mInvalid command\u001B[0m
      """);

  private final String errorMessage;

  CommandError(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  @Override
  public String toString() {
    return errorMessage;
  }
}
