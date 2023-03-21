package com.springbootdrawingapp.commands;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class DrawRectangleCommandTest {

  @InjectMocks
  DrawRectangleCommand drawRectangleCommand;

  @Test
  public void testSetParams() {
    String[] params = {"2", "3", "6", "4"};
    drawRectangleCommand.setParams(params);
    assertEquals(2, drawRectangleCommand.getX1());
    assertEquals(3, drawRectangleCommand.getY1());
    assertEquals(6, drawRectangleCommand.getX2());
    assertEquals(4, drawRectangleCommand.getY2());
  }

  @Test
  public void testSetParamsWithReversedCoordinates() {
    String[] params = {"6", "4", "2", "3"};
    drawRectangleCommand.setParams(params);
    assertEquals(2, drawRectangleCommand.getX1());
    assertEquals(3, drawRectangleCommand.getY1());
    assertEquals(6, drawRectangleCommand.getX2());
    assertEquals(4, drawRectangleCommand.getY2());
  }

  @Test
  public void testSetParamsWithSameCoordinates() {
    String[] params = {"2", "3", "2", "3"};
    drawRectangleCommand.setParams(params);
    assertEquals(2, drawRectangleCommand.getX1());
    assertEquals(3, drawRectangleCommand.getY1());
    assertEquals(2, drawRectangleCommand.getX2());
    assertEquals(3, drawRectangleCommand.getY2());
  }
}