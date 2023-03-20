package com.springbootdrawingapp.factory;

import com.springbootdrawingapp.commands.Command;
import com.springbootdrawingapp.commands.CreateCanvasCommand;
import com.springbootdrawingapp.enums.Commands;
import com.springbootdrawingapp.mapper.CommandsMapper;
import com.springbootdrawingapp.utils.validator.CommandValidator;
import com.springbootdrawingapp.utils.validator.ParamsValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CommandFactoryTest {

  @Mock
  private CommandValidator commandValidator;
  @Mock
  private ParamsValidator paramsValidator;
  @Mock
  private CommandsMapper commandsMapper;
  @Mock
  private CommandFactoryUtil commandFactoryUtil;

  @InjectMocks
  private CommandFactory commandFactory;

  @Test
  void testGetCommand() {
    String userInput = "c 1 10";
    String[] inputArray = userInput.split("\\s+");
    String commandString = inputArray[0];
    String[] params = {"1", "10"};

    doNothing().when(commandValidator).validate(commandString);
    doNothing().when(paramsValidator).validate(commandString, params);
    when(commandsMapper.stringToCommands(commandString)).thenReturn(Commands.CREATE_CANVAS);

    CreateCanvasCommand expectedCommand = new CreateCanvasCommand(new String[]{"1", "10"});
    when(commandFactoryUtil.resolve(Commands.CREATE_CANVAS, params)).thenReturn(expectedCommand);
    Command actualCommand = commandFactory.getCommand(userInput);
    assertEquals(actualCommand, expectedCommand);
  }
}
