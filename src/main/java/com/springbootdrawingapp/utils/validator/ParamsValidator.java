package com.springbootdrawingapp.utils.validator;

import com.springbootdrawingapp.enums.Commands;
import org.springframework.stereotype.Service;

@Service
public class ParamsValidator {

  private final CreateCanvasParamsValidator createCanvasParamsValidator;
  private final DrawLineParamsValidator drawLineParamsValidator;
  private final DrawRectangleValidator drawRectangleValidator;

  public ParamsValidator(CreateCanvasParamsValidator createCanvasParamsValidator, DrawLineParamsValidator drawLineParamsValidator, DrawRectangleValidator drawRectangleValidator) {
    this.createCanvasParamsValidator = createCanvasParamsValidator;
    this.drawLineParamsValidator = drawLineParamsValidator;
    this.drawRectangleValidator = drawRectangleValidator;
  }

  public void validate(String command, String[] params) {
      if (command.equalsIgnoreCase(Commands.CREATE_CANVAS.inputString())) {
        createCanvasParamsValidator.validate(params);
      }
      if (command.equalsIgnoreCase(Commands.NEW_LINE.inputString())) {
        drawLineParamsValidator.validate(params);
      }
      if (command.equalsIgnoreCase(Commands.NEW_RECTANGLE.inputString())) {
        drawRectangleValidator.validate(params);
      }
      if (command.equalsIgnoreCase(Commands.FILL_AREA.inputString())) {
      }
  }
}
