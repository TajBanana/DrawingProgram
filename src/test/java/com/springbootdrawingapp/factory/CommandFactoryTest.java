package com.springbootdrawingapp.factory;

import com.springbootdrawingapp.commands.*;
import com.springbootdrawingapp.exceptions.InvalidCommandException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CommandFactoryTest {
  @Mock
  private CreateCanvasCommand createCanvasCommand;
  @Mock
  private DrawLineCommand drawLineCommand;
  @Mock
  private DrawRectangleCommand drawRectangleCommand;
  @Mock
  private DrawBucketFillCommand drawBucketFillCommand;
  @Mock
  private QuitCommand quitCommand;

  @InjectMocks
  private CommandFactory commandFactory;

  @Test
  void testGetCommandCreateCanvas() {
    Command command = commandFactory.getCommand("C");
    assertTrue(command instanceof CreateCanvasCommand);
    assertEquals(createCanvasCommand, command);
  }

  @Test
  void testGetCommandDrawLine() {
    Command command = commandFactory.getCommand("L");
    assertTrue(command instanceof DrawLineCommand);
    assertEquals(drawLineCommand, command);
  }

  @Test
  void testGetCommandDrawRectangle() {
    Command command = commandFactory.getCommand("R");
    assertTrue(command instanceof DrawRectangleCommand);
    assertEquals(drawRectangleCommand, command);
  }

  @Test
  void testGetCommandDrawBucketFill() {
    Command command = commandFactory.getCommand("B");
    assertTrue(command instanceof DrawBucketFillCommand);
    assertEquals(drawBucketFillCommand, command);
  }

  @Test
  void testGetCommandQuit() {
    Command command = commandFactory.getCommand("Q");
    assertTrue(command instanceof QuitCommand);
    assertEquals(quitCommand, command);
  }

  @Test
  void testGetCommandInvalidCommand() {
    assertThrows(InvalidCommandException.class, () -> commandFactory.getCommand("Z"));
  }

}
