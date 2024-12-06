package com.coding2themax.boardgame.autoconfigure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories(basePackages = "com.coding2themax.boardgame.persistance.repo")
@ComponentScan(basePackages = "com.coding2themax.boardgame.persistance")
public class BoardGamePersistanceAutoConfiguration {

}
