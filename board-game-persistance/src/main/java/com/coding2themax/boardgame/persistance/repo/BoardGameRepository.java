package com.coding2themax.boardgame.persistance.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.coding2themax.boardgame.persistance.model.BoardGame;

@Repository
public interface BoardGameRepository extends ReactiveCrudRepository<BoardGame, Integer> {
}
