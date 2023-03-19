package com.drawingprogram.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CanvasCharTest {
  @Test
  public void testToString() {
    assertEquals("-", CanvasChar.HORIZONTAL.toString());
    assertEquals("|", CanvasChar.VERTICAL.toString());
    assertEquals("x", CanvasChar.LINE.toString());
    assertEquals("o", CanvasChar.FILL.toString());
  }
}
