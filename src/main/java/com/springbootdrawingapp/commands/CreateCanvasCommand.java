package com.springbootdrawingapp.commands;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class CreateCanvasCommand implements Command {
  private int height;
  private int width;

  @Override
  public void setParams(String[] params) {
    this.width = Integer.parseInt(params[0]);
    this.height = Integer.parseInt(params[1]);
  }
}
