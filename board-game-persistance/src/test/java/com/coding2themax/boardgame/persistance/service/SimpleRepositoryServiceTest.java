package com.coding2themax.boardgame.persistance.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.coding2themax.boardgame.persistance.model.BoardGame;
import com.coding2themax.boardgame.persistance.repo.BoardGameRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class SimpleRepositoryServiceTest {

  @Mock
  private BoardGameRepository boardGameRepository;

  @InjectMocks
  private SimpleRepositoryService simpleRepositoryService;

  private BoardGame boardGame;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    boardGame = new BoardGame();
    boardGame.setId(1l);
    boardGame.setName("Catan");
    boardGame.setPublisher("Kosmos");
    boardGame.setYearPublished(1995);
    boardGame.setOutOfPrint(false);
    boardGame.setMinPlayerCount(3);
    boardGame.setMaxPlayerCount(4);
    boardGame.setAgeRating(10);
    boardGame.setPlayingTime(120);
  }

  @Test
  public void testAddBoardGame() {

    Assertions.assertFalse(boardGame.isNew());
    when(boardGameRepository.findById(1l)).thenReturn(Mono.empty());

    when(boardGameRepository.save(any(BoardGame.class))).thenReturn(Mono.just(boardGame));

    Mono<BoardGame> result = simpleRepositoryService.addBoardGame(boardGame);

    StepVerifier.create(result)
        .expectNextMatches(b -> b.isNew() == true);

  }

  @Test
  public void testUpdateBoardGame() {
    when(boardGameRepository.findById(1l)).thenReturn(Mono.just(boardGame));
    when(boardGameRepository.save(any(BoardGame.class))).thenReturn(Mono.just(boardGame));

    Mono<BoardGame> result = simpleRepositoryService.updateBoardGame(boardGame, 1l);

    StepVerifier.create(result)
        .expectNext(boardGame)
        .verifyComplete();
  }

  @Test
  public void testUpdateBoardGameNullVal() {
    when(boardGameRepository.findById(1l)).thenReturn(Mono.just(boardGame));
    when(boardGameRepository.save(any(BoardGame.class))).thenReturn(Mono.just(boardGame));

    BoardGame boardGameEmpty = new BoardGame();
    Mono<BoardGame> result = simpleRepositoryService.updateBoardGame(boardGameEmpty, 1l);

    StepVerifier.create(result)
        .expectNext(boardGame)
        .verifyComplete();
  }

  @Test
  public void testGetBoardGameById() {
    when(boardGameRepository.findById(1l)).thenReturn(Mono.just(boardGame));

    Mono<BoardGame> result = simpleRepositoryService.getBoardGameById("1");

    StepVerifier.create(result)
        .expectNext(boardGame)
        .verifyComplete();
  }

  @Test
  public void testGetAllBoardGames() {
    when(boardGameRepository.findAll()).thenReturn(Flux.just(boardGame));

    Flux<BoardGame> result = simpleRepositoryService.getAllBoardGames();

    StepVerifier.create(result)
        .expectNext(boardGame)
        .verifyComplete();
  }
}
