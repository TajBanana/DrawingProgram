package com.springbootdrawingapp.commands;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class DrawLineCommandTest {

  @InjectMocks
  DrawLineCommand drawLineCommand;

  @Test
  public void testGetters() {
    String[] params = {"2", "3", "5", "7"};
    drawLineCommand.setParams(params);

    assertEquals(2, drawLineCommand.getX1());
    assertEquals(3, drawLineCommand.getY1());
    assertEquals(5, drawLineCommand.getX2());
    assertEquals(7, drawLineCommand.getY2());
  }
}
