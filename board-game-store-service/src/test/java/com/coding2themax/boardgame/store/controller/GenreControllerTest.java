package com.coding2themax.boardgame.store.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.coding2themax.boardgame.persistance.model.Genre;
import com.coding2themax.boardgame.persistance.service.GenreService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@WebFluxTest(controllers = GenreController.class)
public class GenreControllerTest {
  @MockitoBean
  private GenreService genreService;

  @Autowired
  private WebTestClient webTestClient;

  @Test
  void testCreateGenre() {
    Genre genre = new Genre();
    genre.setName("Strategy");

    when(genreService.saveReactive(genre)).thenReturn(Mono.just(genre));

    webTestClient.post()
        .uri("/genres")
        .bodyValue(genre)
        .exchange()
        .expectStatus().isOk()
        .expectBody(Genre.class);
  }

  @Test
  void testGetAllGenres() {
    Genre genre1 = new Genre();
    genre1.setName("Strategy");

    Genre genre2 = new Genre();
    genre2.setName("Adventure");

    when(genreService.findAllReactive()).thenReturn(Flux.just(genre1, genre2));

    webTestClient.get()
        .uri("/genres")
        .exchange()
        .expectStatus().isOk()
        .expectBodyList(Genre.class)
        .hasSize(2);
  }

  @Test
  void testUpdateGenre() {
    Long genreId = 1L;
    Genre genre = new Genre();
    genre.setName("Strategy");

    when(genreService.updateReactive(genreId, genre)).thenReturn(Mono.just(genre));

    webTestClient.put()
        .uri("/genres/{id}", genreId)
        .bodyValue(genre)
        .exchange()
        .expectStatus().isOk()
        .expectBody(Genre.class);
  }
}