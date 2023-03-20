package com.springbootdrawingapp.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CanvasCharTest {
  @Test
  public void testToString() {
    assertEquals("-", CanvasChar.HORIZONTAL.toString());
    assertEquals("|", CanvasChar.VERTICAL.toString());
    assertEquals("x", CanvasChar.LINE.toString());
    assertEquals("o", CanvasChar.FILL.toString());
  }

  @Test
  void testToChar() {
    assertEquals('-', CanvasChar.HORIZONTAL.toChar());
    assertEquals('|', CanvasChar.VERTICAL.toChar());
    assertEquals('x', CanvasChar.LINE.toChar());
    assertEquals('o', CanvasChar.FILL.toChar());
  }
}
