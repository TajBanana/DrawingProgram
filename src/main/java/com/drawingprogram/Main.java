package com.drawingprogram;

import com.drawingprogram.utils.InputScanner;
import com.drawingprogram.utils.Menu;

public class Main {

  public static void main(String[] args) {
    InputProcessor inputProcessor = new InputProcessor();
    InputScanner inputScanner = new InputScanner();

    Menu.print();
    System.out.print("Enter command:");

    while (true) {
      String inputString = inputScanner.scan();
      inputProcessor.process(inputString);
      System.out.print("Enter command:");
    }
  }
}
