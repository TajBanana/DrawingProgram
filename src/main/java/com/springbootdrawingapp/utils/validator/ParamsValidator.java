package com.springbootdrawingapp.utils.validator;

import com.springbootdrawingapp.enums.Commands;
import org.springframework.stereotype.Service;

@Service
public class ParamsValidator {

  private final CreateCanvasParamsValidator createCanvasParamsValidator;
  private final DrawLineParamsValidator drawLineParamsValidator;

  public ParamsValidator(CreateCanvasParamsValidator createCanvasParamsValidator, DrawLineParamsValidator drawLineParamsValidator) {
    this.createCanvasParamsValidator = createCanvasParamsValidator;
    this.drawLineParamsValidator = drawLineParamsValidator;
  }

  public void validate(String command, String[] params) {
      if (command.equalsIgnoreCase(Commands.CREATE_CANVAS.inputString())) {
        createCanvasParamsValidator.validate(params);
      }
      if (command.equalsIgnoreCase(Commands.NEW_LINE.inputString())) {
        drawLineParamsValidator.validate(params);
      }
      if (command.equalsIgnoreCase(Commands.NEW_RECTANGLE.inputString())) {
      }
      if (command.equalsIgnoreCase(Commands.FILL_AREA.inputString())) {
      }
  }
}
