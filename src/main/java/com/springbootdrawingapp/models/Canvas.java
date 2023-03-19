package com.springbootdrawingapp.models;

import com.drawingprogram.exceptions.OutOfBoundsException;
import com.springbootdrawingapp.commands.DrawCommand;

public interface Canvas {
  void addEntity(DrawCommand drawCommand) throws OutOfBoundsException;

  void render();
}
