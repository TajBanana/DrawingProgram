package com.drawingprogram.mapper;

import com.drawingprogram.commands.Command;
import com.drawingprogram.commands.CreateCanvasCommand;
import com.drawingprogram.exceptions.InvalidCommandException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CommandMapperTest {

  @InjectMocks
  private CommandMapper commandMapper;

  @Test
  void testCreateCommand() {
    String commandString = "c";
    String[] params = {"20", "4"};

    Command result = commandMapper.createCommand(commandString, params);

    assertTrue(result instanceof CreateCanvasCommand);
  }

  @Test
  void testInvalidCommand() {
    String commandString = "invalid_command";
    String[] params = {"20", "4"};

    assertThrows(InvalidCommandException.class, () ->
        commandMapper.createCommand(commandString, params)
    );
  }

}