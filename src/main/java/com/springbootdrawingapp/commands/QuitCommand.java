package com.springbootdrawingapp.commands;

public class QuitCommand implements Command{
  public QuitCommand() {
    System.out.println("Closing program...");
    System.exit(0);
  }
}
