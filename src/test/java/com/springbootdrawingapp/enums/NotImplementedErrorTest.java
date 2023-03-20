package com.springbootdrawingapp.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotImplementedErrorTest {
  @Test
  void testToString() {
    assertEquals("""

      \u001B[31mDiagonal line has not been implemented\u001B[0m
      """,
        NotImplementedError.DIAGONAL_LINE.toString());
  }
}