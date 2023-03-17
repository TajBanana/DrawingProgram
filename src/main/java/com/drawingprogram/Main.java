package com.drawingprogram;

import com.drawingprogram.utils.InputScanner;
import com.drawingprogram.utils.Menu;

public class Main {
  private final static InputProcessor inputProcessor = new InputProcessor();
  private final static InputScanner inputScanner = new InputScanner();

  public static void main(String[] args) {
    Menu.print();
    System.out.print("Enter command:");

    while (true) {
      String inputString = inputScanner.scan();
      inputProcessor.process(inputString);
      System.out.print("Enter command:");
    }
  }
}
