package com.coding2themax.boardgame.store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BoardGameNotFoundException extends RuntimeException {

  public BoardGameNotFoundException(String message) {
    super(message);
  }

}
