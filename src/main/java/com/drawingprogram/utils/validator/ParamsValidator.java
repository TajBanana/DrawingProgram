package com.drawingprogram.utils.validator;

import com.drawingprogram.enums.Commands;

public class ParamsValidator {

  public void validate(String command, String[] params) {
      if (command.equalsIgnoreCase(Commands.CREATE_CANVAS.inputString())) {
        CreateCanvasParamsValidator.validate(params);
      }
      if (command.equalsIgnoreCase(Commands.NEW_LINE.inputString())) {
        DrawLineParamsValidator.validate(params);
      }
      if (command.equalsIgnoreCase(Commands.NEW_RECTANGLE.inputString())) {
      }
      if (command.equalsIgnoreCase(Commands.FILL_AREA.inputString())) {
      }
  }
}
