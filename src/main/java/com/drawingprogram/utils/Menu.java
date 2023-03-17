package com.drawingprogram.utils;

import com.drawingprogram.enums.MenuOptions;

public class Menu {

  public static void print() {
    for (MenuOptions option : MenuOptions.values()) {
      System.out.println(option.getDescription());
    }
  }
}
