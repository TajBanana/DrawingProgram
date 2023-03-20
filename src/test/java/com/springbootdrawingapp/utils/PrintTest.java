package com.springbootdrawingapp.utils;

import com.springbootdrawingapp.enums.MenuOptions;
import com.springbootdrawingapp.factory.Menu;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrintTest {

  @Test
  void testMenu() {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    Menu.print();
    String output = outContent.toString().trim();

    System.setOut(System.out);

    String expectedOutput = String.join("\n", MenuOptions.HEADER.getDescription(),
        MenuOptions.CREATE_CANVAS.getDescription(),
        MenuOptions.NEW_LINE.getDescription(),
        MenuOptions.NEW_RECTANGLE.getDescription(),
        MenuOptions.FILL_AREA.getDescription(),
        MenuOptions.QUIT.getDescription());

    assertEquals(expectedOutput, output);
  }
}