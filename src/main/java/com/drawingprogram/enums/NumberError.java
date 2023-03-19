package com.drawingprogram.enums;

public enum NumberError {
  INVALID_NUMBER("""

      \u001B[31mInput must be more than 0\u001B[0m
      """),
  NON_INTEGER("""

      \u001B[31mInput must be an integer\u001B[0m
      """);
  private final String errorMessage;

  NumberError(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  @Override
  public String toString() {
    return errorMessage;
  }

}
