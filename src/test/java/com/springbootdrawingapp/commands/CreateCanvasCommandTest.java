package com.springbootdrawingapp.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CreateCanvasCommandTest {
  @InjectMocks
  CreateCanvasCommand createCanvasCommand;


  @Test
  public void testGetters() {
    String[] params = {"5", "7"};
    createCanvasCommand.setParams(params);

    assertEquals(5, createCanvasCommand.getWidth());
    assertEquals(7, createCanvasCommand.getHeight());
  }
}
