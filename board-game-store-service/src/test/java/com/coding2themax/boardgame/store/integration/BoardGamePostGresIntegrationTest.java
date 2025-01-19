package com.coding2themax.boardgame.store.integration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
public class BoardGamePostGresIntegrationTest {

  @Autowired
  private WebTestClient webTestClient;

  @Test
  void getAllBoardGames() {
    Assertions.assertThat(true);
  }
}
