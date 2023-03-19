/*
package com.springbootdrawingapp.factory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CommandFactoryTest {

  @InjectMocks
  private CommandFactory commandFactory;

  @Test
  public void testGetCommand() {
    String userInput = "command param1 param2";
    String expectedCommand = "command";
    String[] expectedParams = new String[]{"param1", "param2"};

    commandFactory.getCommand(userInput);

    verify(commandFactory).createCommand(expectedCommand, expectedParams);

  }

}*/
