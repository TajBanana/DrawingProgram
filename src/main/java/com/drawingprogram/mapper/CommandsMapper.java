package com.drawingprogram.mapper;

import com.drawingprogram.enums.Commands;

public class CommandsMapper {
  public Commands stringToCommands(String commandString) {
    return switch (commandString.toUpperCase()) {
      case "C" -> Commands.CREATE_CANVAS;
      case "L" -> Commands.NEW_LINE;
      case "F" -> Commands.FILL_AREA;
      case "R" -> Commands.NEW_RECTANGLE;
      default -> Commands.QUIT;
    };
  }

}
