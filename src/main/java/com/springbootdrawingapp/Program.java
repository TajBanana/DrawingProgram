package com.springbootdrawingapp;

import com.springbootdrawingapp.utils.input.InputProcessor;
import com.springbootdrawingapp.utils.input.InputScanner;
import com.springbootdrawingapp.factory.Menu;
import org.springframework.stereotype.Component;

@Component
public class Program {
  final InputProcessor inputProcessor;
  final InputScanner inputScanner;

  public Program(InputProcessor inputProcessor, InputScanner inputScanner) {
    this.inputProcessor = inputProcessor;
    this.inputScanner = inputScanner;
  }

  public void start() {
    Menu.print();
    System.out.print("Enter command:");

    while (true) {
      String inputString = inputScanner.scan();
      inputProcessor.process(inputString);
      System.out.print("Enter command:");
    }
  }
}
