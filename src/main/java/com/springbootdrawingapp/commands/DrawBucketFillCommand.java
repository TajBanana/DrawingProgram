package com.springbootdrawingapp.commands;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class DrawBucketFillCommand implements DrawCommand {
  private int x1;
  private int y1;
  private char fillChar;

  @Override
  public void setParams(String[] params) {
    this.x1 = Integer.parseInt(params[0]);
    this.y1 = Integer.parseInt(params[1]);
    this.fillChar = params[2].charAt(0);
  }
}
