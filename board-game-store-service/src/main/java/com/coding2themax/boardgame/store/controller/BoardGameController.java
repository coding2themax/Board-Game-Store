package com.coding2themax.boardgame.store.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding2themax.boardgame.persistance.model.BoardGame;
import com.coding2themax.boardgame.persistance.service.BookInventoryService;
import com.coding2themax.boardgame.store.exception.BoardGameNotFoundException;

import jakarta.validation.constraints.Min;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.RequestParam;

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

  @GetMapping("/boardgame")
  Mono<BoardGame> getBoardGameById(@RequestParam(value = "id") int id) {
    String idString = Integer.toString(id);
    return boardGameService.getBoardGameById(idString)
        .switchIfEmpty(Mono.error(new BoardGameNotFoundException("Board game not found")));
  }

}
