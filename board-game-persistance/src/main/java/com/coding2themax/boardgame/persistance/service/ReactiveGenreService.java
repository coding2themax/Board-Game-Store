package com.coding2themax.boardgame.persistance.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;

import com.coding2themax.boardgame.persistance.model.Genre;
import com.coding2themax.boardgame.persistance.repo.GenreRepository;

@Service
public class ReactiveGenreService implements GenreService {

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
    return genreRepository.findById(genre.getId()).flatMap(g -> {
      g.setName(null != genre.getName() ? genre.getName() : g.getName());
      return genreRepository.save(g);
    });
  }
}
