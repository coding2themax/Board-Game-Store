package com.coding2themax.boardgame.persistance.service;

import org.springframework.stereotype.Service;

import com.coding2themax.boardgame.persistance.model.BoardGame;
import com.coding2themax.boardgame.persistance.repo.BoardGameRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SimpleRepositoryService implements BookInventoryService {

  private final BoardGameRepository boardGameRepository;

  public SimpleRepositoryService(BoardGameRepository boardGameRepository) {
    this.boardGameRepository = boardGameRepository;
  }

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
    boardGame.setName("Catan - The Settlers of Catan");
    boardGame.setPublisher("Klaus Teuber");
    boardGame.setYearPublished(1995);
    boardGame.setOutOfPrint(false);

    BoardGame boardGame2 = new BoardGame();
    boardGame2.setId(2);
    boardGame2.setName("Ticket to Ride");
    boardGame2.setPublisher("Alan R. Moon");
    boardGame2.setYearPublished(2004);
    boardGame2.setOutOfPrint(false);

    return Flux.just(boardGame, boardGame2);
  }

}
