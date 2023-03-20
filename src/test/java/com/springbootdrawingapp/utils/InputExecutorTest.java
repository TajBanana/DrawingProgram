package com.springbootdrawingapp.utils;

import com.springbootdrawingapp.commands.*;
import com.springbootdrawingapp.exceptions.EmptyCanvasException;
import com.springbootdrawingapp.models.CanvasRectangle;
import com.springbootdrawingapp.utils.input.InputExecutor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InputExecutorTest {

  @Mock
  private CanvasRectangle canvasRectangleMock;
  @InjectMocks
  private InputExecutor inputExecutor;

  @Test
  void testWithoutCanvas_throwEmptyCanvasException() {
    DrawLineCommand createCanvasCommand = new DrawLineCommand(new String[]{"1", "1", "1", "1"});
    assertThrows(EmptyCanvasException.class,
        () -> inputExecutor.execute(createCanvasCommand));
  }

  @Test
  void testExecuteCreateCanvasCommand() {

    CreateCanvasCommand createCanvasCommand = new CreateCanvasCommand(new String[]{"10", "20"});
    inputExecutor.execute(createCanvasCommand);
    verify(canvasRectangleMock).setWidth(10);
    verify(canvasRectangleMock).setHeight(20);
    verify(canvasRectangleMock).constructProperty();

  }

  @Nested
  public class testsWithCanvas {
    @BeforeEach
    void setUp() {
      when(canvasRectangleMock.getCanvasArray()).thenReturn(new char[][]{{' '}, {' '}});
    }

    @Test
    void shouldCallAddEntityWithDrawLineCommand() {
      DrawLineCommand drawLineCommand = mock(DrawLineCommand.class);
      inputExecutor.execute(drawLineCommand);

      verify(canvasRectangleMock).addEntity(drawLineCommand);
    }

    @Test
    void shouldCallAddEntityWithDrawRectangleCommand() {
      DrawRectangleCommand drawRectangleCommand = mock(DrawRectangleCommand.class);
      inputExecutor.execute(drawRectangleCommand);

      verify(canvasRectangleMock).addEntity(drawRectangleCommand);
    }

    @Test
    void shouldCallAddEntityWithDrawBucketFillCommand() {
      DrawBucketFillCommand drawBucketFillCommand = mock(DrawBucketFillCommand.class);
      inputExecutor.execute(drawBucketFillCommand);

      verify(canvasRectangleMock).addEntity(drawBucketFillCommand);
    }
  }
}