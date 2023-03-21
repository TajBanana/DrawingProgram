package com.springbootdrawingapp.models;

import com.springbootdrawingapp.commands.CreateCanvasCommand;
import com.springbootdrawingapp.commands.DrawBucketFillCommand;
import com.springbootdrawingapp.commands.DrawLineCommand;
import com.springbootdrawingapp.commands.DrawRectangleCommand;
import com.springbootdrawingapp.utils.drawing.BucketFillUtil;
import com.springbootdrawingapp.utils.drawing.LineUtil;
import com.springbootdrawingapp.utils.drawing.RectangleUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CanvasRectangleTest {

  @Mock
  private LineUtil lineUtil;
  @Mock
  private RectangleUtil rectangleUtil;
  @Mock
  private BucketFillUtil bucketFillUtil;
  @Mock
  private CreateCanvasCommand createCanvasCommand;

  @InjectMocks
  private CanvasRectangle canvasRectangle;

  @Test
  void testConstruct() {
    int width = 10;
    int height = 5;
    when(createCanvasCommand.getWidth()).thenReturn(width);
    when(createCanvasCommand.getHeight()).thenReturn(height);
    canvasRectangle.construct();
    char[][] expectedCanvasArray = new char[height][width];
    for (char[] row : expectedCanvasArray) {
      Arrays.fill(row, ' ');
    }
    assertArrayEquals(expectedCanvasArray, canvasRectangle.getCanvasArray());
  }

  @Nested
  class testWithCanvas {

    @BeforeEach
    void setUp() {
      int width = 10;
      int height = 10;
      when(createCanvasCommand.getWidth()).thenReturn(width);
      when(createCanvasCommand.getHeight()).thenReturn(height);
      canvasRectangle.construct();
    }

    @Test
    void testAddLineEntity() {
      DrawLineCommand drawLineCommand = mock(DrawLineCommand.class);
      canvasRectangle.addEntity(drawLineCommand);
      verify(lineUtil, times(1)).draw(canvasRectangle.getCanvasArray());
    }

    @Test
    void testAddRectangleEntity() {
      DrawRectangleCommand drawRectangleCommand = mock(DrawRectangleCommand.class);
      canvasRectangle.addEntity(drawRectangleCommand);
      verify(rectangleUtil, times(1)).draw(canvasRectangle.getCanvasArray());
    }

    @Test
    void testAddBucketFillEntity() {
      DrawBucketFillCommand drawRectangleCommand = mock(DrawBucketFillCommand.class);
      canvasRectangle.addEntity(drawRectangleCommand);
      verify(bucketFillUtil, times(1)).draw(canvasRectangle.getCanvasArray());
    }

    @Test
    void testRender() {
      ByteArrayOutputStream outContent = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outContent));

      canvasRectangle.render();

      String output = outContent.toString().trim();

      System.setOut(System.out);

      String expectedOutput = """
          ------------
          |          |
          |          |
          |          |
          |          |
          |          |
          |          |
          |          |
          |          |
          |          |
          |          |
          ------------""";

      assertEquals(expectedOutput, output);
    }
  }
}