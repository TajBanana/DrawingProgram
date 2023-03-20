package com.springbootdrawingapp.models;

import com.springbootdrawingapp.commands.DrawBucketFillCommand;
import com.springbootdrawingapp.commands.DrawRectangleCommand;
import com.springbootdrawingapp.commands.DrawCommand;
import com.springbootdrawingapp.commands.DrawLineCommand;
import com.springbootdrawingapp.factory.CanvasFactory;
import com.springbootdrawingapp.utils.drawing.BucketFillUtil;
import com.springbootdrawingapp.utils.drawing.LineUtil;
import com.springbootdrawingapp.utils.drawing.RectangleUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Setter
@Getter
public class CanvasRectangle implements Canvas {

  private final LineUtil lineUtil;
  private final RectangleUtil rectangleUtil;
  private final BucketFillUtil bucketFillUtil;

  private char[][] canvasArray;
  private int width;
  private int height;

  public CanvasRectangle(LineUtil lineUtil, RectangleUtil rectangleUtil, BucketFillUtil bucketFillUtil) {
    this.lineUtil = lineUtil;
    this.rectangleUtil = rectangleUtil;
    this.bucketFillUtil = bucketFillUtil;
  }

  public void constructProperty() {
    canvasArray = new char[height][width];
    Arrays.stream(canvasArray).forEach(row -> Arrays.fill(row, ' '));
    render();

    System.out.println(width);
    System.out.println(height);
  }

  @Override
  public void addEntity(DrawCommand drawCommand) {
    addEntityHandler(drawCommand);
    render();
  }

  public void render() {
    System.out.println(CanvasFactory.rectangle(width, height, canvasArray));
  }

  public void addEntityHandler(DrawCommand drawCommand) {
    if (drawCommand instanceof DrawLineCommand) {
      lineUtil.draw((DrawLineCommand) drawCommand, canvasArray);
    }
    else if (drawCommand instanceof DrawRectangleCommand) {
      rectangleUtil.draw((DrawRectangleCommand) drawCommand, canvasArray);
    }
    else if (drawCommand instanceof DrawBucketFillCommand) {
      bucketFillUtil.fill((DrawBucketFillCommand) drawCommand, canvasArray);

    }
  }
}
