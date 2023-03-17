package com.drawingprogram.commands;

import com.drawingprogram.enums.MenuOptions;
import lombok.Getter;

@Getter
public  class CreateCanvasCommand implements Command {
  private final int height;
  private final int width;

  public CreateCanvasCommand(String[] params) {
    this.width = Integer.parseInt(params[0]);
    this.height = Integer.parseInt(params[1]);
  }


}
