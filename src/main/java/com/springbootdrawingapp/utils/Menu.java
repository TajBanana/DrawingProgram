package com.springbootdrawingapp.utils;

import com.springbootdrawingapp.enums.MenuOptions;

public class Menu {

  public static void print() {
    for (MenuOptions option : MenuOptions.values()) {
      System.out.println(option.getDescription());
    }
  }
}
