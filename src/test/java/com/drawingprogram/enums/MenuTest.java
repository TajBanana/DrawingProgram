package com.drawingprogram.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
  @Test
  public void testGetDescription() {
    assertEquals("Command         Description", MenuOptions.HEADER.getDescription());
    assertEquals("C w h           Should create a new canvas of width w and height h.", MenuOptions.CREATE_CANVAS.getDescription());
    assertEquals("""
        L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only
                        horizontal or vertical lines are supported. Horizontal and vertical lines
                        will be drawn using the 'x' character.""", MenuOptions.NEW_LINE.getDescription());
    assertEquals("""
        R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and
                        lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
                        using the 'x' character.""", MenuOptions.NEW_RECTANGLE.getDescription());
    assertEquals("""
        B x y c         Should fill the entire area connected to (x,y) with "colour" c. The
                        behavior of this is the same as that of the "bucket fill" tool in paint
                        programs.""", MenuOptions.FILL_AREA.getDescription());
    assertEquals("Q               Should quit the program.", MenuOptions.QUIT.getDescription());
  }

  @Test
  public void testValues() {
    MenuOptions[] expectedValues = {MenuOptions.HEADER, MenuOptions.CREATE_CANVAS, MenuOptions.NEW_LINE, MenuOptions.NEW_RECTANGLE, MenuOptions.FILL_AREA, MenuOptions.QUIT};
    MenuOptions[] actualValues = MenuOptions.values();
    assertArrayEquals(expectedValues, actualValues);
  }

  @Test
  public void testToString() {
    assertEquals("HEADER", MenuOptions.HEADER.toString());
    assertEquals("CREATE_CANVAS", MenuOptions.CREATE_CANVAS.toString());
    assertEquals("NEW_LINE", MenuOptions.NEW_LINE.toString());
    assertEquals("NEW_RECTANGLE", MenuOptions.NEW_RECTANGLE.toString());
    assertEquals("FILL_AREA", MenuOptions.FILL_AREA.toString());
    assertEquals("QUIT", MenuOptions.QUIT.toString());
  }
}