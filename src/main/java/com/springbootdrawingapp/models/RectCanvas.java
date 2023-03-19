package com.springbootdrawingapp.models;

import com.drawingprogram.exceptions.OutOfBoundsException;
import com.springbootdrawingapp.commands.DrawCommand;
import com.springbootdrawingapp.commands.DrawLineCommand;
import com.springbootdrawingapp.factory.CanvasFactory;
import com.springbootdrawingapp.utils.LineUtil;

import java.util.Arrays;

public class RectCanvas implements Canvas{

  private final char[][] canvasArray;
  private final int width;
  private final int height;

  public RectCanvas(int w, int h) {
    this.width = w;
    this.height = h;

    canvasArray = new char[width][height];
    Arrays.stream(canvasArray).forEach(row -> Arrays.fill(row, ' '));
    render();
  }

  @Override
  public void addEntity(DrawCommand drawCommand) throws OutOfBoundsException {
    System.out.println(drawCommand);
    LineUtil lineUtil = new LineUtil();
    lineUtil.draw((DrawLineCommand) drawCommand, canvasArray);
    render();
  }

  public void render() {
    System.out.println(CanvasFactory.rectangle(width, height, canvasArray));
  }
}
