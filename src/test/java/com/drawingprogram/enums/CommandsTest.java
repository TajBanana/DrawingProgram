package com.drawingprogram.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommandsTest {

  @Test
  public void testGetInputCommand() {
    assertEquals("C", Commands.CREATE_CANVAS.inputString());
    assertEquals("L", Commands.NEW_LINE.inputString());
    assertEquals("R", Commands.NEW_RECTANGLE.inputString());
    assertEquals("B", Commands.FILL_AREA.inputString());
    assertEquals("Q", Commands.QUIT.inputString());
  }

  @Test
  public void testValues() {
    Commands[] expectedValues = {Commands.CREATE_CANVAS, Commands.NEW_LINE, Commands.NEW_RECTANGLE, Commands.FILL_AREA, Commands.QUIT};
    Commands[] actualValues = Commands.values();
    assertArrayEquals(expectedValues, actualValues);
  }

  @Test
  public void testToString() {
    assertEquals("CREATE_CANVAS", Commands.CREATE_CANVAS.toString());
    assertEquals("NEW_LINE", Commands.NEW_LINE.toString());
    assertEquals("NEW_RECTANGLE", Commands.NEW_RECTANGLE.toString());
    assertEquals("FILL_AREA", Commands.FILL_AREA.toString());
    assertEquals("QUIT", Commands.QUIT.toString());
  }
}