package com.springbootdrawingapp.utils;

import com.springbootdrawingapp.commands.*;
import com.springbootdrawingapp.exceptions.EmptyCanvasException;
import com.springbootdrawingapp.models.CanvasRectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
    //problem here, how to make sure my canvas is not null?

    CanvasRectangle canvasRectangle = mock(CanvasRectangle.class);

    @BeforeEach
    void setUp() {
      CreateCanvasCommand createCanvasCommand =
          new CreateCanvasCommand(new String[]{"20", "20"});
      inputExecutor.execute(createCanvasCommand);
    }

    @Test
    void shouldCallAddEntityWithDrawLineCommand() {
      CreateCanvasCommand createCanvasCommand =
          new CreateCanvasCommand(new String[]{"20", "20"});
      inputExecutor.execute(createCanvasCommand);

      DrawLineCommand drawLineCommand = mock(DrawLineCommand.class);
      canvasRectangle.constructProperty();
      inputExecutor.execute(drawLineCommand);
      verify(canvasRectangle).addEntity(drawLineCommand);
    }
  }
}