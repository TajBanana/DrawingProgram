package com.springbootdrawingapp.utils;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputScannerTest {

  @Test
  public void testScan() {
    InputScanner inputScanner = new InputScanner();
    System.setIn(new ByteArrayInputStream("test".getBytes()));

    assertEquals("test", inputScanner.scan());
  }
}