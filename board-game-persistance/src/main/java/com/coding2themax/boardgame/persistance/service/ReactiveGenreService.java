package com.coding2themax.boardgame.persistance.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.coding2themax.boardgame.persistance.model.Genre;
import com.coding2themax.boardgame.persistance.repo.GenreRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactiveGenreService implements GenreService {
  private static final Logger LOGGER = LoggerFactory.getLogger(ReactiveGenreService.class);
  private final GenreRepository genreRepository;

  public ReactiveGenreService(GenreRepository genreRepository) {
    this.genreRepository = genreRepository;
  }

  @Override
  public Flux<Genre> findAllReactive() {
    return genreRepository.findAll();
  }

  @Override
  public Mono<Genre> saveReactive(Genre genre) {
    return saveGenreOrUpdate(genre);
  }

  @Override
  public Mono<Genre> findByIdReactive(Long id) {
    return genreRepository.findById(id);
  }

  private Mono<Genre> saveGenreOrUpdate(Genre genre) {
    LOGGER.info("Checkin if genre exists: {}", genre);
    Long id = Optional.ofNullable(genre.getId()).orElse(-1L);
    LOGGER.info("Genre id: {}", id);
    return genreRepository.findById(id).flatMap(g -> {
      g.setName(genre.getName());
      return genreRepository.save(g);
    }).switchIfEmpty(this.genreRepository.save(genre));
  }

  @Override
  public Mono<Genre> updateReactive(Long id, Genre genre) {
    genre.setId(id);
    return saveGenreOrUpdate(genre);
  }
}
