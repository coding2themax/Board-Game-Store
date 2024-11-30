package com.coding2themax.boardgame.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.coding2themax.boardgame.")
public class BoardGameStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardGameStoreApplication.class, args);
	}

}
