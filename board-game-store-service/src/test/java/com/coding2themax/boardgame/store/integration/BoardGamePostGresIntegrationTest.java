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
        .expectBodyList(Genre.class).hasSize(3);

  }

  @Test
  void testUpdateGenre() {
    Genre genre1 = new Genre();

    genre1.setId(1l);
    genre1.setName("test1");

    Genre genre2 = new Genre();
    genre2.setId(1l);
    genre2.setName("test2");

    genreService.saveReactive(
        genre1)
        .subscribe();
    webTestClient.put().uri("/genres/1").bodyValue(genre2).exchange().expectStatus().isOk()
        .expectBody(Genre.class).value(v -> {
          // Assertions.assertThat(v.getId()).isEqualTo(1l);
          Assertions.assertThat(v.getName()).isEqualTo("test2");
        });

  }

  @Test
  void testAddNewGenreForPost() {

    Genre genre1 = new Genre();

    genre1.setId(1l);
    genre1.setName("test1");

    genreService.saveReactive(
        genre1).subscribe();
    Genre genre2 = new Genre();

    genre2.setId(1l);

    webTestClient.post().uri("/genres").bodyValue(genre1).exchange().expectStatus().isOk()
        .expectBody(Genre.class).value(v -> {
          // Assertions.assertThat(v.getId()).isEqualTo(1l);
          Assertions.assertThat(v.getName()).isEqualTo("test1");
        });

    genre2.setName("testupdate");

    Long genreId = 1L;

    webTestClient.put().uri("/genres/{id}", genreId).bodyValue(genre2).exchange().expectStatus().isOk()
        .expectBody(Genre.class).value(v -> {
          Assertions.assertThat(v.getId()).isEqualTo(1l);
          Assertions.assertThat(v.getName()).isEqualTo("testupdate");

        });
  }

}
