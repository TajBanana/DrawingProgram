package com.springbootdrawingapp.commands;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class DrawBucketFillCommandTest {

  @InjectMocks
  private DrawBucketFillCommand drawBucketFillCommand;

  @Test
  void setParams() {
    String[] params = {"1", "2", "C"};
    drawBucketFillCommand.setParams(params);

    assertEquals(1, drawBucketFillCommand.getX1());
    assertEquals(2, drawBucketFillCommand.getY1());
    assertEquals('C', drawBucketFillCommand.getFillChar());
  }

}