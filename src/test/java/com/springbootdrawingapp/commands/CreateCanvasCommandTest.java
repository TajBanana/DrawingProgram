package com.springbootdrawingapp.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CreateCanvasCommandTest {

  @Test
  public void testGetWidth() {
    CreateCanvasCommand command = new CreateCanvasCommand(new String[] { "10", "5" });
    int width = command.getWidth();
    assertEquals(10, width);
  }

  @Test
  public void testGetHeight() {
    CreateCanvasCommand command = new CreateCanvasCommand(new String[] { "10", "5" });
    int height = command.getHeight();
    assertEquals(5, height);
  }

}
