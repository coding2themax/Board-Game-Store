package com.coding2themax.boardgame.persistance.service;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.coding2themax.boardgame.persistance.model.Genre;
import com.coding2themax.boardgame.persistance.repo.GenreRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class ReactiveGenreServiceTest {

  @Mock
  private GenreRepository genreRepository;

  @InjectMocks
  private ReactiveGenreService genreService;

  @BeforeEach
  void setUP() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testFindAllReactive() {

    Genre genre = new Genre();
    genre.setId(1L);
    genre.setName("Strategy");

    // Given
    when(genreRepository.findAll()).thenReturn(Flux.just(genre));

    // When
    Flux<Genre> result = genreService.findAllReactive();

    // Then
    StepVerifier.create(result)
        .expectNext(genre)
        .verifyComplete();

  }

  @Test
  void testFindByIdReactive() {

    Genre genre = new Genre();
    genre.setId(1L);
    genre.setName("Strategy");

    // Given
    when(genreRepository.findById(1L)).thenReturn(Mono.just(genre));

    // When
    Mono<Genre> result = genreService.findByIdReactive(1l);

    // Then
    StepVerifier.create(result)
        .expectNext(genre)
        .verifyComplete();

  }

  @Test
  void testSaveReactive() {

    Genre genre = new Genre();
    genre.setId(1L);
    genre.setName("Strategy");

    // Given
    when(genreRepository.findById(1L)).thenReturn(Mono.just(genre));
    when(genreRepository.save(genre)).thenReturn(Mono.just(genre));

    // When
    Mono<Genre> result = genreService.saveReactive(genre);

    // Then
    StepVerifier.create(result)
        .expectNext(genre)
        .verifyComplete();

  }
}
