package com.springbootdrawingapp.models;

import com.springbootdrawingapp.commands.*;
import com.springbootdrawingapp.factory.CanvasFactory;
import com.springbootdrawingapp.utils.drawing.BucketFillUtil;
import com.springbootdrawingapp.utils.drawing.LineUtil;
import com.springbootdrawingapp.utils.drawing.RectangleUtil;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CanvasRectangle implements Canvas {

  private final LineUtil lineUtil;

  private final RectangleUtil rectangleUtil;

  private final BucketFillUtil bucketFillUtil;

  private final CreateCanvasCommand createCanvasCommand;

  @Getter
  private char[][] canvasArray;
  private int width;
  private int height;

  public CanvasRectangle(LineUtil lineUtil,
                         RectangleUtil rectangleUtil,
                         BucketFillUtil bucketFillUtil,
                         CreateCanvasCommand createCanvasCommand) {
    this.lineUtil = lineUtil;
    this.rectangleUtil = rectangleUtil;
    this.bucketFillUtil = bucketFillUtil;
    this.createCanvasCommand = createCanvasCommand;
  }

  public void construct() {
    this.width = createCanvasCommand.getWidth();
    this.height = createCanvasCommand.getHeight();
    canvasArray = new char[this.height][width];
    Arrays.stream(canvasArray).forEach(row -> Arrays.fill(row, ' '));
    render();
  }

  @Override
  public void addEntity(DrawCommand drawCommand) {
    addEntityHandler(drawCommand);
    render();
  }

  public void addEntityHandler(DrawCommand drawCommand) {
    if (drawCommand instanceof DrawLineCommand) {
      lineUtil.draw((DrawLineCommand) drawCommand, canvasArray);
    }
    else if (drawCommand instanceof DrawRectangleCommand) {
      rectangleUtil.draw((DrawRectangleCommand) drawCommand, canvasArray);
    }
    else if (drawCommand instanceof DrawBucketFillCommand) {
      bucketFillUtil.draw((DrawBucketFillCommand) drawCommand, canvasArray);

    }
  }

  public void render() {
    System.out.println(CanvasFactory.rectangle(width, height, canvasArray));
  }
}
