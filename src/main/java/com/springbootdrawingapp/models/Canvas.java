package com.springbootdrawingapp.models;

import com.springbootdrawingapp.exceptions.OutOfBoundsException;
import com.springbootdrawingapp.commands.DrawCommand;

public interface Canvas {
  void addEntity(DrawCommand drawCommand) throws OutOfBoundsException;

  void render();
}
