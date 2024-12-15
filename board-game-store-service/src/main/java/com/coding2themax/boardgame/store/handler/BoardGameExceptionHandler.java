package com.coding2themax.boardgame.store.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

import com.coding2themax.boardgame.store.exception.BoardGameNotFoundException;

@ControllerAdvice
public class BoardGameExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(BoardGameNotFoundException.class)
  protected ResponseEntity<Object> handleBoardGameNotFoundException(RuntimeException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }
}
