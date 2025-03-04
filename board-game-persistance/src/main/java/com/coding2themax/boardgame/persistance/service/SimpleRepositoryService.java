package com.coding2themax.boardgame.persistance.service;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.coding2themax.boardgame.persistance.model.BoardGame;
import com.coding2themax.boardgame.persistance.repo.BoardGameRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SimpleRepositoryService implements BoardGameInventoryService {

  private static final Logger LOGGER = Logger.getLogger(SimpleRepositoryService.class.getName());
  private final BoardGameRepository boardGameRepository;

  public SimpleRepositoryService(BoardGameRepository boardGameRepository) {
    this.boardGameRepository = boardGameRepository;
  }

  @Override
  public Mono<BoardGame> addBoardGame(BoardGame boardGame) {
    return saveBoardGameOrUpdate(boardGame);
  }

  @Override
  public Mono<BoardGame> updateBoardGame(BoardGame boardGame, Long id) {
    boardGame.setId(id);
    return saveBoardGameOrUpdate(boardGame);
  }

  @Override
  public Mono<BoardGame> getBoardGameById(String id) {
    return boardGameRepository.findById(Long.valueOf(id));
  }

  @Override
  public Flux<BoardGame> getAllBoardGames() {
    return boardGameRepository.findAll();
  }

  private Mono<BoardGame> saveBoardGameOrUpdate(BoardGame boardGame) {
    LOGGER.info(null != boardGame.getId() ? "Updating board game with id: " + boardGame.getId()
        : "Adding new board game");
    Long id = Optional.ofNullable(boardGame.getId()).orElse(0l);
    return this.boardGameRepository.findById(id).flatMap(b -> {
      b.setName(null != boardGame.getName() ? boardGame.getName() : b.getName());
      b.setPublisher(null != boardGame.getPublisher() ? boardGame.getPublisher() : b.getPublisher());
      b.setYearPublished(null != boardGame.getYearPublished() ? boardGame.getYearPublished() : b.getYearPublished());
      b.setOutOfPrint(null != boardGame.isOutOfPrint() ? boardGame.isOutOfPrint() : b.isOutOfPrint());
      b.setMinPlayerCount(
          null != boardGame.getMinPlayerCount() ? boardGame.getMinPlayerCount() : b.getMinPlayerCount());
      b.setMaxPlayerCount(
          null != boardGame.getMaxPlayerCount() ? boardGame.getMaxPlayerCount() : b.getMaxPlayerCount());
      b.setAgeRating(null != boardGame.getAgeRating() ? boardGame.getAgeRating() : b.getAgeRating());
      b.setPlayingTime(null != boardGame.getPlayingTime() ? boardGame.getPlayingTime() : b.getPlayingTime());
      return this.boardGameRepository.save(b);
    }).switchIfEmpty(this.boardGameRepository.save(boardGame));
  }
}
