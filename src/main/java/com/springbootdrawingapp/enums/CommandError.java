package com.springbootdrawingapp.enums;

public enum CommandError {
  INVALID_COMMAND("""

      \u001B[31mInvalid command\u001B[0m
      """),
  EMPTY_CANVAS("""

      \u001B[31mPlease create a canvas first!!!\u001B[0m
      """),
  OUT_OF_BOUNDS("""

      \u001B[31mOut of bounds!\u001B[0m
      """),
  INVALID_FILL("""

      \u001B[31mInvalid fill argument\u001B[0m
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
