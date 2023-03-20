package com.springbootdrawingapp.utils.drawing;

import com.springbootdrawingapp.commands.DrawRectangleCommand;
import com.springbootdrawingapp.exceptions.OutOfBoundsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RectangleUtilTest {

  @InjectMocks
  private RectangleUtil rectangleUtil;

  @Mock
  private LineUtil lineUtil;

  @Test
  void draw_whenCommandIsOutOfBounds_throwsException() {
    char[][] canvasArray = new char[5][5];
    String[] params = new String[]{"10", "10", "20", "20"};

    DrawRectangleCommand command = new DrawRectangleCommand(params);

    Assertions.assertThrows(OutOfBoundsException.class, () -> rectangleUtil.draw(command, canvasArray));
  }

  @Test
  void draw_whenCommandIsWithinBounds_drawsRectangle() {
    // Given
    String[] params = new String[]{"1", "1", "3", "3"};
    DrawRectangleCommand command = new DrawRectangleCommand(params);
    char[][] canvasArray = new char[4][4];

    rectangleUtil.draw(command, canvasArray);

    verify(lineUtil).drawLine(1, 1, 3, 1, canvasArray);
    verify(lineUtil).drawLine(1, 1, 1, 3, canvasArray);
    verify(lineUtil).drawLine(3, 1, 3, 3, canvasArray);
    verify(lineUtil).drawLine(1, 3, 3, 3, canvasArray);
  }
}
