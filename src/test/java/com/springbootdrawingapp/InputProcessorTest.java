package com.springbootdrawingapp;

import com.springbootdrawingapp.commands.Command;
import com.springbootdrawingapp.exceptions.InvalidCanvasParamException;
import com.springbootdrawingapp.exceptions.InvalidCommandException;
import com.springbootdrawingapp.factory.CommandFactory;
import com.springbootdrawingapp.utils.input.InputExecutor;
import com.springbootdrawingapp.utils.input.InputProcessor;
import com.springbootdrawingapp.utils.validator.ParamsValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class InputProcessorTest {

  @Mock
  private CommandFactory commandFactory;
  @Mock
  private InputExecutor inputExecutor;
  @Mock
  private ParamsValidator paramsValidator;

  @InjectMocks
  private InputProcessor inputProcessor;

  @Test
  void testProcessValidInput() {
    String inputString = "C 20 4";
    String commandString = "C";
    String[] params = {"20", "4"};
    Command command = mock(Command.class);

    when(commandFactory.getCommand(commandString)).thenReturn(command);
    doNothing().when(paramsValidator).validate(commandString, params);

    inputProcessor.process(inputString);

    verify(command).setParams(params);
    verify(inputExecutor).execute(command);
  }

  @Test
  void testProcessInvalidCommand() {
    String inputString = "Z";
    String commandString = "Z";

    when(commandFactory.getCommand(commandString)).thenThrow(InvalidCommandException.class);

    inputProcessor.process(inputString);

    verifyNoInteractions(paramsValidator, inputExecutor);
  }

  @Test
  void testProcessInvalidParams() {
    String inputString = "C 20 A";
    String commandString = "C";
    String[] params = {"20", "A"};
    Command command = mock(Command.class);

    when(commandFactory.getCommand(commandString)).thenReturn(command);
    doThrow(InvalidCanvasParamException.class).when(paramsValidator)
                                              .validate(commandString,
                                                  params);

    inputProcessor.process(inputString);

    verifyNoInteractions(inputExecutor);
  }

}
