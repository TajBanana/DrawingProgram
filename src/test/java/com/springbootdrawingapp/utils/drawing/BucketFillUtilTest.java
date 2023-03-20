package com.springbootdrawingapp.utils.drawing;

import com.springbootdrawingapp.commands.DrawBucketFillCommand;
import com.springbootdrawingapp.exceptions.OutOfBoundsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BucketFillUtilTest {
  private BucketFillUtil bucketFillUtil;

  @BeforeEach
  void setUp() {
    bucketFillUtil = new BucketFillUtil();
  }

  @Test
  void fill_whenCommandIsOutOfBounds_throwsException() {
    String[] params = new String[]{"10", "10", "o"};
    DrawBucketFillCommand command = new DrawBucketFillCommand(params);
    char[][] canvasArray = new char[5][5];

    assertThrows(OutOfBoundsException.class, () -> bucketFillUtil.fill(command, canvasArray));
  }

  @Test
  void fill_whenCommandIsWithinBounds_fillsCorrectly() {
    String[] params = new String[]{"2", "2", "o"};

    DrawBucketFillCommand command = new DrawBucketFillCommand(params);
    char[][] canvasArray = new char[][]{
        {'x', 'x', 'x', 'x'},
        {'x', ' ', ' ', 'x'},
        {'x', ' ', ' ', 'x'},
        {'x', 'x', 'x', 'x'}
    };
    char[][] expected = new char[][]{
        {'x', 'x', 'x', 'x'},
        {'x', 'o', 'o', 'x'},
        {'x', 'o', 'o', 'x'},
        {'x', 'x', 'x', 'x'}
    };

    bucketFillUtil.fill(command, canvasArray);
    assertArrayEquals(expected, canvasArray);
  }
}