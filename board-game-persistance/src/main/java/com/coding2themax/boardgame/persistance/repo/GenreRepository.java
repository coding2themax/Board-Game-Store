package com.coding2themax.boardgame.persistance.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.coding2themax.boardgame.persistance.model.Genre;

public interface GenreRepository extends ReactiveCrudRepository<Genre, Long> {

}
