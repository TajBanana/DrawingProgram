package com.springbootdrawingapp.utils.input;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class InputScanner {

  public String scan() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }
}
