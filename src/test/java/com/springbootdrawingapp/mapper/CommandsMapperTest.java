package com.springbootdrawingapp.mapper;

import com.springbootdrawingapp.enums.Commands;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CommandsMapperTest {

  @InjectMocks
  private CommandsMapper mapper;

  @Test
  void stringToCommands_CreateCanvas_ReturnsCreateCanvasCommand() {
    String commandString = "C";
    Commands expected = Commands.CREATE_CANVAS;

    Commands actual = mapper.stringToCommands(commandString);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  void stringToCommands_NewLine_ReturnsNewLineCommand() {
    String commandString = "L";
    Commands expected = Commands.NEW_LINE;

    Commands actual = mapper.stringToCommands(commandString);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  void stringToCommands_FillArea_ReturnsFillAreaCommand() {
    String commandString = "B";
    Commands expected = Commands.FILL_AREA;

    Commands actual = mapper.stringToCommands(commandString);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  void stringToCommands_NewRectangle_ReturnsNewRectangleCommand() {
    String commandString = "R";
    Commands expected = Commands.NEW_RECTANGLE;

    Commands actual = mapper.stringToCommands(commandString);

    Assertions.assertEquals(expected, actual);
  }

  @Test
  void stringToCommands_Quit_ReturnsQuitCommand() {
    String commandString = "Q";
    Commands expected = Commands.QUIT;

    Commands actual = mapper.stringToCommands(commandString);

    Assertions.assertEquals(expected, actual);
  }
}
