
package com.coding2themax.boardgame.store.controller;

import static org.mockito.Mockito.when;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.coding2themax.boardgame.persistance.model.BoardGame;
import com.coding2themax.boardgame.persistance.service.BookInventoryService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@WebFluxTest(controllers = BoardGameController.class)
public class BoardGameControllerTest {

  @MockitoBean
  private BookInventoryService boardGameService;

  @Autowired
  private WebTestClient webTestClient;

  @Test
  public void testGetAllBoardGames() {
    BoardGame game1 = new BoardGame();
    game1.setId(1);
    game1.setName("Game 1");

    BoardGame game2 = new BoardGame();
    game2.setId(2);
    game2.setName("Game 2");
    when(boardGameService.getAllBoardGames()).thenReturn(Flux.just(game1, game2));

    webTestClient.get().uri("/boardgames")
        .exchange()
        .expectStatus().isOk()
        .expectBodyList(BoardGame.class)
        .hasSize(2);
    // .contains(game1, game2);

  }

  /// Create a test for the get by id method in the BoardGameController class
  /// The test should return a single BoardGame object when the id is passed as a query parameter
  /// The test should return a 404 status code when the id is not found
  /// The test should return a 400 status code when the id is not a number
  /// The test should return a 200 status code when the id is found
  /// The test should return a 500 status code when an exception is thrown
  /// The test should return a 200 status code when the id is found

  @Test
  public void testGetBoardGameById() {
    BoardGame game1 = new BoardGame();
    game1.setId(1);
    game1.setName("Game 1");

    when(boardGameService.getBoardGameById("1")).thenReturn(Mono.just(game1));

    webTestClient.get().uri("/boardgame?id=1")
        .exchange()
        .expectStatus().isOk()
        .expectBody(BoardGame.class);
  }

  @Test
  public void testGetBoardGameByIdNotFound() {
    when(boardGameService.getBoardGameById("99")).thenReturn(Mono.empty());

    webTestClient.get().uri("/boardgame?id=99")
        .exchange()
        .expectStatus().isNotFound();
  }
}
