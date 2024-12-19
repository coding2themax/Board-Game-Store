package com.coding2themax.boardgame.persistance.service;

import com.coding2themax.boardgame.persistance.model.Genre;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GenreService {

  Mono<Genre> findByIdReactive(Long id);

  Flux<Genre> findAllReactive();

  Mono<Genre> saveReactive(Genre genre);

}