package com.coding2themax.boardgame.persistance.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardGameTest {

  @Test
  public void testGettersAndSetters() {
    BoardGame game = new BoardGame();
    game.setId(1l);
    game.setName("Catan");
    game.setPublisher("Kosmos");
    game.setYearPublished(1995);
    game.setOutOfPrint(false);
    game.setMinPlayerCount(3);
    game.setMaxPlayerCount(4);
    game.setPlayingTime(120);
    game.setAgeRating(10);

    assertEquals(1, game.getId());
    assertEquals("Catan", game.getName());
    assertEquals("Kosmos", game.getPublisher());
    assertEquals(1995, game.getYearPublished());
    assertFalse(game.isOutOfPrint());
    assertEquals(3, game.getMinPlayerCount());
    assertEquals(4, game.getMaxPlayerCount());
    assertEquals(120, game.getPlayingTime());
    assertEquals(10, game.getAgeRating());
  }

  @Test
  public void testOutOfPrint() {
    BoardGame game = new BoardGame();
    game.setOutOfPrint(true);
    assertTrue(game.isOutOfPrint());
  }

  @Test
  public void testYearPublished() {
    BoardGame game = new BoardGame();
    game.setYearPublished(2000);
    assertEquals(2000, game.getYearPublished());
  }

  @Test
  public void testIsNew() {
    BoardGame game = new BoardGame();
    assertTrue(game.isNew());

    game.setId(1l);
    assertFalse(game.isNew());

    game.setAsNew();
    assertTrue(game.isNew());
  }

  @Test
  public void testSetAsNew() {
    BoardGame game = new BoardGame();
    game.setAsNew();
    assertTrue(game.isNew());
  }

  @Test
  public void testMinPlayerCount() {
    BoardGame game = new BoardGame();
    game.setMinPlayerCount(2);
    assertEquals(2, game.getMinPlayerCount());
  }

  @Test
  public void testMaxPlayerCount() {
    BoardGame game = new BoardGame();
    game.setMaxPlayerCount(6);
    assertEquals(6, game.getMaxPlayerCount());
  }

  @Test
  public void testPlayingTime() {
    BoardGame game = new BoardGame();
    game.setPlayingTime(90);
    assertEquals(90, game.getPlayingTime());
  }

  @Test
  public void testAgeRating() {
    BoardGame game = new BoardGame();
    game.setAgeRating(12);
    assertEquals(12, game.getAgeRating());
  }
}
