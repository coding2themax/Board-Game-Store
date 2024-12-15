package com.coding2themax.boardgame.persistance.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "board_game", schema = "board_game_store")
public class BoardGame implements Persistable<Long> {
  @Id()
  @Column("board_id")
  private Long id;
  @Column("board_name")
  private String name;
  @Column("publisher")
  private String publisher;
  @Column("release_year")
  private Integer yearPublished;
  @Column("out_of_print")
  private Boolean outOfPrint;
  @Column("max_players")
  private Integer minPlayerCount;
  @Column("min_players")
  private Integer maxPlayerCount;
  @Column("play_time_in_minutes")
  private Integer playingTime;
  @Column("age_recommendation")
  private Integer ageRating;

  @Transient
  private boolean isNewBoardGame;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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

  public Integer getYearPublished() {
    return yearPublished;
  }

  public void setYearPublished(int yearPublished) {
    this.yearPublished = yearPublished;
  }

  public Boolean isOutOfPrint() {
    return outOfPrint;
  }

  public void setOutOfPrint(boolean outOfPrint) {
    this.outOfPrint = outOfPrint;
  }

  @Override
  public boolean isNew() {
    return this.isNewBoardGame || id == null;
  }

  public BoardGame setAsNew() {
    this.isNewBoardGame = true;
    return this;
  }
}
