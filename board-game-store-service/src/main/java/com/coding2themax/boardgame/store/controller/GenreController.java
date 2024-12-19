package com.coding2themax.boardgame.store.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.coding2themax.boardgame.persistance.model.Genre;
import com.coding2themax.boardgame.persistance.service.GenreService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class GenreController {

  private final GenreService genreService;

  public GenreController(GenreService genreService) {
    this.genreService = genreService;
  }

  @GetMapping("/genres")
  @ResponseBody
  public Flux<Genre> getAllGenres() {
    return genreService.findAllReactive();
  }

  @PostMapping("/genres")
  @ResponseBody
  public Mono<Genre> createGenre(@RequestBody Genre genre) {
    return genreService.saveReactive(genre);
  }

  @PutMapping("/genres/{id}")
  @ResponseBody
  public Mono<Genre> updateGenre(@PathVariable Long id, @RequestBody Genre genre) {
    return genreService.updateReactive(id, genre);
  }

}
