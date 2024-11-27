package com.coding2themax.boardgame.store.config;

import org.springframework.context.annotation.Bean;

import com.coding2themax.boardgame.persistance.service.BookInventoryService;
import com.coding2themax.boardgame.persistance.service.SimpleRepositoryService;

@org.springframework.context.annotation.Configuration
public class Configuration {

  @Bean
  public BookInventoryService simplService() {
    return new SimpleRepositoryService();
  }
}
