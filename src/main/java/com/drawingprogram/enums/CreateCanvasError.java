package com.drawingprogram.enums;

public enum CreateCanvasError {
  INVALID_PARAMS("""

      \u001B[31mCreate command expects 2 params\u001B[0m
      """);

  private final String errorMessage;

  CreateCanvasError(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  @Override
  public String toString() {
    return errorMessage;
  }

}

