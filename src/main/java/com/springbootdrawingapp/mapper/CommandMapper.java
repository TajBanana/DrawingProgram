/*
package com.springbootdrawingapp.mapper;

import com.springbootdrawingapp.commands.*;
import com.springbootdrawingapp.enums.Commands;
import com.springbootdrawingapp.utils.validator.CommandValidator;
import com.springbootdrawingapp.utils.validator.ParamsValidator;
import org.springframework.stereotype.Service;

@Service
public class CommandMapper {
  private final CommandValidator commandValidator;
  private final ParamsValidator paramsValidator;
  private final CommandsMapper commandsMapper;
  private final CreateCanvasCommand createCanvasCommand;
  private final DrawLineCommand drawLineCommand;
  private final DrawRectangleCommand drawRectangleCommand;
  private final FloodFillCommand floodFillCommand;
  private final QuitCommand quitCommand;


  public CommandMapper(CommandValidator commandValidator, ParamsValidator paramsValidator, CommandsMapper commandsMapper, CreateCanvasCommand createCanvasCommand, DrawLineCommand drawLineCommand, DrawRectangleCommand drawRectangleCommand, FloodFillCommand floodFillCommand, QuitCommand quitCommand) {
    this.commandValidator = commandValidator;
    this.paramsValidator = paramsValidator;
    this.commandsMapper = commandsMapper;
    this.createCanvasCommand = createCanvasCommand;
    this.drawLineCommand = drawLineCommand;
    this.drawRectangleCommand = drawRectangleCommand;
    this.floodFillCommand = floodFillCommand;
    this.quitCommand = quitCommand;
  }

*/
/*
  public Command createCommand(String commandString, String[] params) {
    Commands command = commandsMapper.stringToCommands(commandString);

    commandValidator.validate(commandString);
    paramsValidator.validate(commandString, params);

    return switch (command) {
      case CREATE_CANVAS -> new CreateCanvasCommand(params);
      case NEW_LINE -> new DrawLineCommand(params);
      case NEW_RECTANGLE -> new DrawRectangleCommand();
      case FILL_AREA -> new FloodFillCommand();
      case QUIT -> new QuitCommand();
    };
  }
*//*

}
*/
