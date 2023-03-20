package com.springbootdrawingapp.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DrawLineCommandTest {

  private DrawLineCommand drawLineCommand;
  private final String[] params = new String[]{"1", "5", "13", "10"};


  @BeforeEach
  void setUp() {
    drawLineCommand = new DrawLineCommand(params);
  }

  @Test
  void testGetX1() {
    assertEquals(drawLineCommand.getX1(), Math.min(Integer.parseInt(params[0]), Integer.parseInt(params[2])));
  }

  @Test
  void testGetY1() {
    assertEquals(drawLineCommand.getY1(), Math.min(Integer.parseInt(params[1]), Integer.parseInt(params[3])));
  }

  @Test
  void testGetX2() {
    assertEquals(drawLineCommand.getX2(), Math.max(Integer.parseInt(params[0]), Integer.parseInt(params[2])));
  }

  @Test
  void testGetY2() {
    assertEquals(drawLineCommand.getY2(), Math.max(Integer.parseInt(params[1]), Integer.parseInt(params[3])));
  }

}
