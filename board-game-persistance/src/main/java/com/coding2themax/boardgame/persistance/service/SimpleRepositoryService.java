package com.coding2themax.boardgame.persistance.service;

import com.coding2themax.boardgame.persistance.model.BoardGame;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class SimpleRepositoryService implements BookInventoryService {

  @Override
  public Mono<BoardGame> addBoardGame(BoardGame boardGame) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addBoardGame'");
  }

  @Override
  public Mono<BoardGame> updateBoardGame(BoardGame boardGame) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateBoardGame'");
  }

  @Override
  public Mono<Void> deleteBoardGameById(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteBoardGameById'");
  }

  @Override
  public Mono<BoardGame> getBoardGameById(String id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getBoardGameById'");
  }

  @Override
  public Flux<BoardGame> getAllBoardGames() {

    BoardGame boardGame = new BoardGame();
    boardGame.setId(1);
    boardGame.setName("Catan");
    boardGame.setPublisher("Klaus Teuber");
    boardGame.setYearPublished(1995);
    boardGame.setOutOfPrint(false);

    return Flux.just(boardGame);
  }

}
