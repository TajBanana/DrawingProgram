package com.springbootdrawingapp.enums;

public enum CanvasChar {
  HORIZONTAL('-'),
  VERTICAL('|'),
  LINE('x'),
  FILL('o'),
  ;

  private final char character;

  CanvasChar(char character) {
    this.character = character;
  }

  public char toChar() {
    return character;
  }

  @Override
  public String toString() {
    return String.valueOf(character);
  }
}
