package com.springbootdrawingapp.models;

import com.springbootdrawingapp.commands.DrawBucketFillCommand;
import com.springbootdrawingapp.commands.DrawRectangleCommand;
import com.springbootdrawingapp.commands.DrawCommand;
import com.springbootdrawingapp.commands.DrawLineCommand;
import com.springbootdrawingapp.factory.CanvasFactory;
import com.springbootdrawingapp.utils.BucketFillUtil;
import com.springbootdrawingapp.utils.LineUtil;
import com.springbootdrawingapp.utils.RectangleUtil;

import java.util.Arrays;

public class CanvasRectangle implements Canvas{

  private final char[][] canvasArray;
  private final int width;
  private final int height;

  public CanvasRectangle(int w, int h) {
    this.width = w;
    this.height = h;

    canvasArray = new char[height][width];
    Arrays.stream(canvasArray).forEach(row -> Arrays.fill(row, ' '));
    render();
  }

  @Override
  public void addEntity(DrawCommand drawCommand) {
    //System.out.println(drawCommand);
    addEntityHandler(drawCommand);
    render();
  }

  public void render() {
    System.out.println(CanvasFactory.rectangle(width, height, canvasArray));
  }

  public void addEntityHandler(DrawCommand drawCommand) {
    if (drawCommand instanceof DrawLineCommand) {
      LineUtil lineUtil = new LineUtil();
      lineUtil.draw((DrawLineCommand) drawCommand, canvasArray);
    }
    else if (drawCommand instanceof DrawRectangleCommand) {
      RectangleUtil rectangleUtil = new RectangleUtil();
      rectangleUtil.draw((DrawRectangleCommand) drawCommand,canvasArray);
    }
    else if (drawCommand instanceof DrawBucketFillCommand) {
      BucketFillUtil bucketFillUtil = new BucketFillUtil();
      bucketFillUtil.fill((DrawBucketFillCommand) drawCommand, canvasArray);

    }
  }
}
