package com.springbootdrawingapp;

import com.springbootdrawingapp.commands.Command;
import com.springbootdrawingapp.exceptions.EmptyCanvasException;
import com.springbootdrawingapp.factory.CommandFactory;
import com.springbootdrawingapp.utils.input.InputExecutor;
import com.springbootdrawingapp.utils.input.InputProcessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InputProcessorTest {

  @Mock
  private CommandFactory commandFactory;

  @Mock
  private InputExecutor inputExecutor;

  @InjectMocks
  private InputProcessor inputProcessor;

  @Test
  public void process_withNoCanvas_shouldThrowException() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    String inputString = "b 1 10";
    when(commandFactory.getCommand(inputString)).thenThrow(new EmptyCanvasException());
    inputProcessor.process(inputString);

    assertEquals("""

        \u001B[31mPlease create a canvas first!!!\u001B[0m
        
        """, outContent.toString());
  }

  @Test
  public void process_withValidInput_shouldExecuteCommand() {
    String inputString = "valid input";
    Command command = mock(Command.class);
    when(commandFactory.getCommand(inputString)).thenReturn(command);

    inputProcessor.process(inputString);

    verify(inputExecutor).execute(command);
  }

}
