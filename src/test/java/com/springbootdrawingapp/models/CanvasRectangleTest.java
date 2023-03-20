package com.springbootdrawingapp.models;

import com.springbootdrawingapp.commands.DrawBucketFillCommand;
import com.springbootdrawingapp.commands.DrawLineCommand;
import com.springbootdrawingapp.commands.DrawRectangleCommand;
import com.springbootdrawingapp.utils.drawing.BucketFillUtil;
import com.springbootdrawingapp.utils.drawing.LineUtil;
import com.springbootdrawingapp.utils.drawing.RectangleUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CanvasRectangleTest {

  @InjectMocks
  private CanvasRectangle canvasRectangle;

  @Mock
  private LineUtil lineUtil;

  @Mock
  private RectangleUtil rectangleUtil;

  @Mock
  private BucketFillUtil bucketFillUtil;

  @BeforeEach
  public void setUp() {
    canvasRectangle = new CanvasRectangle(lineUtil, rectangleUtil, bucketFillUtil);
    canvasRectangle.setWidth(10);
    canvasRectangle.setHeight(5);
    canvasRectangle.constructProperty();
  }

  @Test
  public void testConstructProperty() {
    assertEquals(canvasRectangle.getWidth(), 10);
    assertEquals(canvasRectangle.getHeight(), 5);
    assertEquals(canvasRectangle.getCanvasArray().length, 5);
    assertEquals(canvasRectangle.getCanvasArray()[0].length, 10);
    assertEquals(canvasRectangle.getCanvasArray()[0][0], ' ');
  }

  @Test
  public void testAddEntity() {
    String[] drawLineParams = new String[]{"1", "2", "3", "2"};
    DrawLineCommand drawLineCommand = new DrawLineCommand(drawLineParams);
    doNothing().when(lineUtil).draw(drawLineCommand, canvasRectangle.getCanvasArray());
    canvasRectangle.addEntity(drawLineCommand);
    verify(lineUtil, times(1)).draw(drawLineCommand, canvasRectangle.getCanvasArray());


    String[] drawRectangleParams = new String[]{"1", "5", "1", "5"};
    DrawRectangleCommand drawRectangleCommand = new DrawRectangleCommand(drawRectangleParams);
    canvasRectangle.addEntity(drawRectangleCommand);
    verify(rectangleUtil, times(1)).draw(drawRectangleCommand, canvasRectangle.getCanvasArray());

    String[] drawBucketFillParams = new String[]{"1", "1", "o"};
    DrawBucketFillCommand drawBucketFillCommand = new DrawBucketFillCommand(drawBucketFillParams);
    canvasRectangle.addEntity(drawBucketFillCommand);
    verify(bucketFillUtil, times(1)).fill(drawBucketFillCommand, canvasRectangle.getCanvasArray());
  }

  @Test
  public void testSetWidth() {
    canvasRectangle.setWidth(20);
    assertEquals(canvasRectangle.getWidth(), 20);
  }

  @Test
  public void testSetHeight() {
    canvasRectangle.setHeight(10);
    assertEquals(canvasRectangle.getHeight(), 10);
  }

  @Test
  public void testSetCanvasArray() {
    char[][] newCanvasArray = new char[][] {{'a', 'b'}, {'c', 'd'}};
    canvasRectangle.setCanvasArray(newCanvasArray);
    assertEquals(canvasRectangle.getCanvasArray(), newCanvasArray);
  }
}
