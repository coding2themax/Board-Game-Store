package com.coding2themax.boardgame.persistance.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "board_game", schema = "board_game_store")
public class BoardGame {
  @Id()
  @Column("board_id")
  private Integer id;
  @Column("board_name")
  private String name;
  @Column("publisher")
  private String publisher;
  @Column("release_year")
  private int yearPublished;
  @Column("out_of_print")
  private boolean outOfPrint;
  @Column("max_players")
  private Integer minPlayerCount;
  @Column("min_players")
  private Integer maxPlayerCount;
  @Column("play_time_in_minutes")
  private Integer playingTime;
  @Column("age_recommendation")
  private Integer ageRating;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPublisher() {
    return publisher;
  }

  public Integer getMinPlayerCount() {
    return minPlayerCount;
  }

  public void setMinPlayerCount(Integer minPlayerCount) {
    this.minPlayerCount = minPlayerCount;
  }

  public Integer getMaxPlayerCount() {
    return maxPlayerCount;
  }

  public void setMaxPlayerCount(Integer maxPlayerCount) {
    this.maxPlayerCount = maxPlayerCount;
  }

  public Integer getPlayingTime() {
    return playingTime;
  }

  public void setPlayingTime(Integer playingTime) {
    this.playingTime = playingTime;
  }

  public Integer getAgeRating() {
    return ageRating;
  }

  public void setAgeRating(Integer ageRating) {
    this.ageRating = ageRating;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public int getYearPublished() {
    return yearPublished;
  }

  public void setYearPublished(int yearPublished) {
    this.yearPublished = yearPublished;
  }

  public boolean isOutOfPrint() {
    return outOfPrint;
  }

  public void setOutOfPrint(boolean outOfPrint) {
    this.outOfPrint = outOfPrint;
  }
}
