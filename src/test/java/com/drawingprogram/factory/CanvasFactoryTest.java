package com.drawingprogram.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CanvasFactoryTest {

  @Test
  public void testRectangle() {
    char[][] canvasArray = new char[][]{
        {' ', 'x', ' '},
        {'x', ' ', 'x'},
        {' ', 'x', ' '}
    };
    String expectedOutput =
        """
            -----
            | x |
            |x x|
            | x |
            -----""";

    String actualOutput = CanvasFactory.rectangle(3, 3, canvasArray);

    assertEquals(expectedOutput, actualOutput);
  }
}