package com.springbootdrawingapp.commands;

import lombok.Getter;

@Getter
public class DrawLineCommand implements DrawCommand {
  private final int x1;
  private final int y1;
  private final int x2;
  private final int y2;


  public DrawLineCommand(String[] params) {
    this.x1 = Math.min(Integer.parseInt(params[0]), Integer.parseInt(params[2]));
    this.y1 = Math.min(Integer.parseInt(params[1]), Integer.parseInt(params[3]));
    this.x2 = Math.max(Integer.parseInt(params[0]), Integer.parseInt(params[2]));
    this.y2 = Math.max(Integer.parseInt(params[1]), Integer.parseInt(params[3]));
  }
}
