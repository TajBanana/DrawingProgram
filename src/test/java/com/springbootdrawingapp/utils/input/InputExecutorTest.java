package com.springbootdrawingapp.utils.input;

import com.springbootdrawingapp.commands.*;
import com.springbootdrawingapp.exceptions.EmptyCanvasException;
import com.springbootdrawingapp.models.CanvasRectangle;
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
  private CanvasRectangle canvasRectangle;

  @InjectMocks
  private InputExecutor inputExecutor;

  @Test
  public void executeQuitCommand() {
    QuitCommand quitCommand = mock(QuitCommand.class);
    inputExecutor.execute(quitCommand);
    verify(quitCommand).execute();
  }

  @Test
  public void executeCreateCanvasCommand() {
    CreateCanvasCommand createCanvasCommand = mock(CreateCanvasCommand.class);
    inputExecutor.execute(createCanvasCommand);
    verify(canvasRectangle).construct();
  }

  @Test
  public void nullCanvasThrowsEmptyCanvasException() {
    DrawLineCommand drawLineCommand = mock(DrawLineCommand.class);
    when(canvasRectangle.getCanvasArray()).thenReturn(null);
    assertThrows(EmptyCanvasException.class, () -> inputExecutor.execute(drawLineCommand));
    verify(canvasRectangle, never()).addEntity(drawLineCommand);
  }

  @Test
  public void executeDrawLineCommand() {
    DrawLineCommand drawLineCommand = mock(DrawLineCommand.class);
    when(canvasRectangle.getCanvasArray()).thenReturn(new char[3][3]);
    inputExecutor.execute(drawLineCommand);
    verify(canvasRectangle).addEntity(drawLineCommand);
  }

  @Test
  public void executeDrawBucketFillCommand() {
    DrawBucketFillCommand drawBucketFillCommand = mock(DrawBucketFillCommand.class);
    when(canvasRectangle.getCanvasArray()).thenReturn(new char[3][3]);
    inputExecutor.execute(drawBucketFillCommand);
    verify(canvasRectangle).addEntity(drawBucketFillCommand);
  }

  @Test
  public void executeDrawRectangleCommand() {
    DrawRectangleCommand drawRectangleCommand = mock(DrawRectangleCommand.class);
    when(canvasRectangle.getCanvasArray()).thenReturn(new char[3][3]);
    inputExecutor.execute(drawRectangleCommand);
    verify(canvasRectangle).addEntity(drawRectangleCommand);
  }
}
