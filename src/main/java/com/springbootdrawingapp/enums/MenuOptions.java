package com.springbootdrawingapp.enums;

public enum MenuOptions {
  HEADER ("Command         Description"),
  CREATE_CANVAS ("C w h           Should create a new canvas of width w and " +
      "height h."),
  NEW_LINE ("""
      L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only
                      horizontal or vertical lines are supported. Horizontal and vertical lines
                      will be drawn using the 'x' character."""),
  NEW_RECTANGLE ("""
      R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and
                      lower right corner is (x2,y2). Horizontal and vertical lines will be drawn
                      using the 'x' character."""),
  FILL_AREA ("""
      B x y c         Should fill the entire area connected to (x,y) with "colour" c. The
                      behavior of this is the same as that of the "bucket fill" tool in paint
                      programs."""),
  QUIT ("Q               Should quit the program.");

  private final String description;

  MenuOptions(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
