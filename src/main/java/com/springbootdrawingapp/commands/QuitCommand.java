package com.springbootdrawingapp.commands;

import org.springframework.stereotype.Service;

@Service
public class QuitCommand implements Command{
  @Override
  public void setParams(String[] params) {
  }

  public void execute() {
    System.out.println("Closing program...");
    System.exit(0);
  }
}
