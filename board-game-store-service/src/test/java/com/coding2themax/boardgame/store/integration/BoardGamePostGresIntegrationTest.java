package com.coding2themax.boardgame.store.integration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.coding2themax.boardgame.persistance.model.Genre;
import com.coding2themax.boardgame.persistance.service.GenreService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient(timeout = "36000")
@Testcontainers
public class BoardGamePostGresIntegrationTest {

  @Autowired
  private WebTestClient webTestClient;

  @Autowired
  private GenreService genreService;

  @Test
  void getAllBoardGames() {

    webTestClient.get().uri("/genres").exchange().expectStatus().isOk()
        .expectBodyList(Genre.class).hasSize(0);

    Genre genre1 = new Genre();

    genre1.setId(1l);
    genre1.setName("test");

    genreService.saveReactive(
        genre1)
        .subscribe(s -> webTestClient.get().uri("/genres").exchange().expectBodyList(Genre.class).contains(genre1));

  }

  @Test
  void testAddGenre() {
    Genre genre1 = new Genre();

    genre1.setId(1l);
    genre1.setName("test1");

    webTestClient.post().uri("/genres").bodyValue(genre1).exchange().expectStatus().isOk()
        .expectBody(Genre.class).value(v -> {
          Assertions.assertThat(v.getId()).isEqualTo(1l);
          Assertions.assertThat(v.getName()).isEqualTo("test1");
        });
  }

}
