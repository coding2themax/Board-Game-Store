CREATE SCHEMA IF NOT EXISTS board_game_store;


CREATE TABLE board_game_store.board_game (
  board_id SERIAL PRIMARY KEY,
  board_name VARCHAR(255) NOT NULL,
  publisher VARCHAR(255),
  release_year NUMERIC(4),
  genre VARCHAR(100),
  min_players numeric(2),
  max_players numeric(2),
  out_of_print BOOLEAN,
  play_time_in_minutes INT,
  age_recommendation INT
);

CREATE TABLE board_game_store.publishers (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  country VARCHAR(100)
);

CREATE TABLE board_game_store.genres (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

insert into board_game_store.genres (name) values ('Strategy');
insert into board_game_store.genres (name) values ('Family');
insert into board_game_store.genres (name) values ('Party');

insert into board_game_store.board_game ( board_name, publisher, release_year, genre, min_players, max_players, out_of_print, play_time_in_minutes, age_recommendation) values ( 'Catan', 'Catan Studio', 1995, 'Strategy', 3, 4, false, 60, 10);
insert into board_game_store.board_game ( board_name, publisher, release_year, genre, min_players, max_players, out_of_print, play_time_in_minutes, age_recommendation) values ( 'Catan', 'Catan Studio', 1995, 'Strategy', 3, 4, false, 60, 10);
insert into board_game_store.board_game ( board_name, publisher, release_year, genre, min_players, max_players, out_of_print, play_time_in_minutes, age_recommendation) values ( 'Ticket to Ride', 'Days of Wonder', 2004, 'Strategy', 2, 5, false, 60, 8); 