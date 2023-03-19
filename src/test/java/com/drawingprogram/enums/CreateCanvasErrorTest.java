package com.drawingprogram.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateCanvasErrorTest {

  @Test
  public void testErrorMessageForInvalidParamsError() {
    String expectedErrorMessage = """

        \u001B[31mCreate command expects 2 params\u001B[0m
        """;
    String actualErrorMessage = ParamsLengthError.CREATE_COMMAND.toString();
    assertEquals(expectedErrorMessage, actualErrorMessage);
  }
}