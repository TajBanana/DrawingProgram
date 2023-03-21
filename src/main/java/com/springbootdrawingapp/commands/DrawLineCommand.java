package com.springbootdrawingapp.commands;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class DrawLineCommand implements DrawCommand {
  private int x1;
  private int y1;
  private int x2;
  private int y2;

  @Override
  public void setParams(String[] params) {
    this.x1 = Math.min(Integer.parseInt(params[0]), Integer.parseInt(params[2]));
    this.y1 = Math.min(Integer.parseInt(params[1]), Integer.parseInt(params[3]));
    this.x2 = Math.max(Integer.parseInt(params[0]), Integer.parseInt(params[2]));
    this.y2 = Math.max(Integer.parseInt(params[1]), Integer.parseInt(params[3]));
  }
}
