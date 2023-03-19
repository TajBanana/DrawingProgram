package com.springbootdrawingapp;

import com.springbootdrawingapp.utils.InputProcessor;
import com.springbootdrawingapp.utils.InputScanner;
import com.springbootdrawingapp.utils.Menu;
import org.springframework.stereotype.Component;

@Component
public class Program {
  InputProcessor inputProcessor;
  InputScanner inputScanner;

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
