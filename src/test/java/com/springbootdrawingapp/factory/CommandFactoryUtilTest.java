package com.springbootdrawingapp.factory;

import com.springbootdrawingapp.commands.*;
import com.springbootdrawingapp.enums.Commands;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandFactoryUtilTest {
  private final CommandFactoryUtil commandFactoryUtil = new CommandFactoryUtil();

  @Test
  void testCreateCanvas() {
    String[] params = new String[]{"1", "10"};
    assertEquals(commandFactoryUtil.resolve(Commands.CREATE_CANVAS, params)
                                   .getClass(), CreateCanvasCommand.class);
  }

  @Test
  void testDrawLine() {
    String[] params = new String[]{"1", "10", "1", "10"};
    assertEquals(commandFactoryUtil.resolve(Commands.NEW_LINE, params)
                                   .getClass(), DrawLineCommand.class);
  }

  @Test
  void testDrawRectangle() {
    String[] params = new String[]{"1", "10", "1", "10"};
    assertEquals(commandFactoryUtil.resolve(Commands.NEW_RECTANGLE, params)
                                   .getClass(), DrawRectangleCommand.class);
  }

  @Test
  void testFillArea() {
    String[] params = new String[]{"1", "10", "c"};
    assertEquals(commandFactoryUtil.resolve(Commands.FILL_AREA, params)
                                   .getClass(), DrawBucketFillCommand.class);
  }

//  Quit command not tested because it will quit the entire program during test


}