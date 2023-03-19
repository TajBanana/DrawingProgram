package com.springbootdrawingapp.enums;

public enum ParamsLengthError {
  CREATE_COMMAND("""

      \u001B[31mCreate command expects 2 params\u001B[0m
      """),
  LINE_COMMAND("""

      \u001B[31mLine command expects 4 params\u001B[0m
      """),
  RECTANGLE_COMMAND("""

      \u001B[31mCreate command expects 4 params\u001B[0m
      """),
  BUCKET_FILL_COMMAND("""

      \u001B[31mCreate command expects 3 params\u001B[0m
      """),;


  private final String errorMessage;

  ParamsLengthError(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  @Override
  public String toString() {
    return errorMessage;
  }

}

