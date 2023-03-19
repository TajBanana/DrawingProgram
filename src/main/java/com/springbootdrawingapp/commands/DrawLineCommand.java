package com.springbootdrawingapp.commands;

public class DrawLineCommand implements Command {
  private final int x1;
  private final int y1;
  private final int x2;
  private final int y2;


  public DrawLineCommand(String[] params) {
    this.x1 = Integer.parseInt(params[0]);
    this.y1 = Integer.parseInt(params[1]);
    this.x2 = Integer.parseInt(params[2]);
    this.y2 = Integer.parseInt(params[3]);
  }

  @Override
  public String toString() {
    return "DrawLineCommand{" +
        "x1=" + x1 +
        ", y1=" + y1 +
        ", x2=" + x2 +
        ", y2=" + y2 +
        '}';
  }
}
