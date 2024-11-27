package com.coding2themax.boardgame.persistance.model;

public class BoardGame {
  private long id;

  private String name;
  private String publisher;
  private int yearPublished;
  private boolean outOfPrint;

  public long getId() {
    return id;
  }

  public void setId(long id) {
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
