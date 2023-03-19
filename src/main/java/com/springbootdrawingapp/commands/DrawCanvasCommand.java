package com.springbootdrawingapp.commands;

import lombok.Getter;

@Getter
public class DrawCanvasCommand implements Command {
  private final int height;
  private final int width;

  public DrawCanvasCommand(String[] params) {
    this.width = Integer.parseInt(params[0]);
    this.height = Integer.parseInt(params[1]);
  }
}
