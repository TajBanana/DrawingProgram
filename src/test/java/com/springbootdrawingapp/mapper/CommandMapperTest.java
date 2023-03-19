///*
//package com.springbootdrawingapp.mapper;
//
//import com.springbootdrawingapp.commands.*;
//import com.springbootdrawingapp.enums.Commands;
//import com.springbootdrawingapp.exceptions.InvalidCommandException;
//import com.springbootdrawingapp.utils.validator.CommandValidator;
//import com.springbootdrawingapp.utils.validator.ParamsValidator;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.util.AssertionErrors.fail;
//
//@ExtendWith(MockitoExtension.class)
//class CommandMapperTest {
//
//  @Mock
//  CommandValidator commandValidator;
//
//  @Mock
//  ParamsValidator paramsValidator;
//
//  @Mock
//  CommandsMapper commandsMapper;
//
//  @InjectMocks
//  CommandMapper commandMapper;
//
//  @Test
//  void testCreateCommand() {
//    String commandString = "CREATE_CANVAS";
//    String[] params = {"20", "4"};
//    Commands command = Commands.CREATE_CANVAS;
//
//    when(commandsMapper.stringToCommands(commandString)).thenReturn(command);
//
//    Command result = commandMapper.createCommand(commandString, params);
//
//    verify(commandsMapper, times(1)).stringToCommands(commandString);
//    verify(commandValidator, times(1)).validate(commandString);
//    verify(paramsValidator, times(1)).validate(commandString, params);
//
//    switch (command) {
//      case CREATE_CANVAS -> assertTrue(result instanceof CreateCanvasCommand);
//      case NEW_LINE -> assertTrue(result instanceof DrawLineCommand);
//      case NEW_RECTANGLE -> assertTrue(result instanceof DrawRectangleCommand);
//      case FILL_AREA -> assertTrue(result instanceof FloodFillCommand);
//      case QUIT -> assertTrue(result instanceof QuitCommand);
//      default -> fail("Invalid command");
//    }
//  }
//}
//*/
