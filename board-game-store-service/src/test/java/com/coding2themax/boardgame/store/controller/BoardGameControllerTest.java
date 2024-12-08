
package com.coding2themax.boardgame.store.controller;

import static org.mockito.Mockito.when;

import org.checkerframework.checker.units.qual.A;
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
}
