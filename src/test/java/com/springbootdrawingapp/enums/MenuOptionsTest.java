package com.springbootdrawingapp.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuOptionsTest {

  @Test
  public void testGetDescriptionForHeader() {
    String expectedDescription = "Command         Description";
    String actualDescription = MenuOptions.HEADER.getDescription();
    assertEquals(expectedDescription, actualDescription);
  }

  @Test
  public void testGetDescriptionForCreateCanvasOption() {
    String expectedDescription = "C w h           Should create a new canvas of width w and height h.";
    String actualDescription = MenuOptions.CREATE_CANVAS.getDescription();
    assertEquals(expectedDescription, actualDescription);
  }

  @Test
  public void testGetDescriptionForNewLineOption() {
    String expectedDescription = """
        L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only
                        horizontal or vertical lines are supported. Horizontal and vertical lines
                        will be drawn using the 'x' character.""";
    String actualDescription = MenuOptions.NEW_LINE.getDescription();
    assertEquals(expectedDescription, actualDescription);
  }

  @Test
  public void testGetDescriptionForNewRectangleOption() {
    String expectedDescription = """
        R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and
                        lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
                        using the 'x' character.""";
    String actualDescription = MenuOptions.NEW_RECTANGLE.getDescription();
    assertEquals(expectedDescription, actualDescription);
  }

  @Test
  public void testGetDescriptionForFillArea() {
    String expectedDescription = """
        B x y c         Should fill the entire area connected to (x,y) with "colour" c. The
                        behavior of this is the same as that of the "bucket fill" tool in paint
                        programs.""";
    String actualDescription = MenuOptions.FILL_AREA.getDescription();

    assertEquals(expectedDescription, actualDescription);
  }

  @Test
  public void testGetDescriptionForQuit() {
    String expectedDescription = "Q               Should quit the program.";
    String actualDescription = MenuOptions.QUIT.getDescription();

    assertEquals(expectedDescription, actualDescription);
  }

}