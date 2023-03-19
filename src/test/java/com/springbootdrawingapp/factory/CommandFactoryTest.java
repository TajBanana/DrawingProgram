package com.springbootdrawingapp.factory;

import com.springbootdrawingapp.commands.Command;
import com.springbootdrawingapp.commands.CreateCanvasCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandFactoryTest {

  @Test
  public void testCreateCommand() {
    CommandFactory commandFactory = new CommandFactory();
    Command command = commandFactory.getCommand("C 5 10");
    int width = ((CreateCanvasCommand) command).getWidth();
    int height = ((CreateCanvasCommand) command).getHeight();

    assertEquals(command.getClass(), CreateCanvasCommand.class);
    assertEquals(width, 5);
    assertEquals(height, 10);
  }

}