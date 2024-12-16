package com.coding2themax.boardgame.persistance.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "genres", schema = "board_game_store")
public class Genre implements Persistable<Long> {
  @Id()
  private Long id;
  @Column
  private String name;

  @Transient
  private boolean isNewGenre;

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

  @Override
  public boolean isNew() {
    return this.isNewGenre || id == null;
  }

  public Genre setIsNewGenre() {
    this.isNewGenre = true;
    return this;
  }

}
