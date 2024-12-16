package com.coding2themax.boardgame.persistance.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

public class GenreTest {

  @Test
  public void testGenreName() {
    Genre genre = new Genre();
    genre.setName("Strategy");
    assertEquals("Strategy", genre.getName());
  }

  @Test
  public void testGenreId() {
    Genre genre = new Genre();
    genre.setId(1L);
    assertEquals(1L, genre.getId());
  }

  @Test
  public void testGenreDescription() {
    Genre genre = new Genre();
    genre.setId(1l);
    genre.setName("Games that require strategic thinking.");
    Assertions.assertFalse(genre.isNew());
    genre.setIsNewGenre();
    Assertions.assertTrue(genre.isNew());
  }
}
