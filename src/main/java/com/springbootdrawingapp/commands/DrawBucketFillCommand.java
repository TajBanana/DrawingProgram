package com.springbootdrawingapp.commands;

import lombok.Getter;

@Getter
public class DrawBucketFillCommand implements DrawCommand{
  private final int x1;
  private final int y1;
  private final char fillChar;

  public DrawBucketFillCommand(String[] params) {
    this.x1 = Integer.parseInt(params[0]);
    this.y1 = Integer.parseInt(params[1]);
    this.fillChar = params[2].charAt(0);
  }
}
