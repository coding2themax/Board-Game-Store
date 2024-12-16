package com.coding2themax.boardgame.persistance.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.coding2themax.boardgame.persistance.model.BoardGame;

public interface BookInventoryService {

  Mono<BoardGame> addBoardGame(BoardGame boardGame);

  Mono<BoardGame> updateBoardGame(BoardGame boardGame, Long id);

  Mono<BoardGame> getBoardGameById(String id);

  Flux<BoardGame> getAllBoardGames();
}
