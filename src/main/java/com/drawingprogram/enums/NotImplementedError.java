package com.drawingprogram.enums;

public enum NotImplementedError {
  DIAGONAL_LINE("""

      \u001B[31mDiagonal line has not been implemented\u001B[0m
      """);

  private final String errorMessage;

  NotImplementedError(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  @Override
  public String toString() {
    return errorMessage;
  }
}
