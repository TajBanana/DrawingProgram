package com.drawingprogram.models;

import com.drawingprogram.factory.CanvasFactory;

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
  }

  @Override
  public void addEntity() {

  }

  public void render() {
    System.out.println(CanvasFactory.rectangle(width, height, canvasArray));
  }
}
