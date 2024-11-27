package com.coding2themax.boardgame.store.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding2themax.boardgame.persistance.model.BoardGame;
import com.coding2themax.boardgame.persistance.service.BookInventoryService;

import reactor.core.publisher.Flux;

@RestController
public class BoardGameController {

  private final BookInventoryService boardGameService;

  public BoardGameController(BookInventoryService boardGameService) {
    this.boardGameService = boardGameService;
  }

  @GetMapping("/boardgames")
  Flux<BoardGame> getAllBoardGames() {
    return boardGameService.getAllBoardGames();
  }
}
