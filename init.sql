CREATE SCHEMA IF NOT EXISTS board_game_store;


CREATE TABLE board_game_store.board_game (
  board_id NUMERIC(3) PRIMARY KEY,
  board_name VARCHAR(255) NOT NULL,
  publisher VARCHAR(255),
  release_year NUMERIC(4),
  genre VARCHAR(100),
  min_players numeric(2),
  max_players numeric(2),
  out_of_print BOOLEAN,
  play_time_minutes INT,
  age_recommendation INT
);

CREATE TABLE board_game_store.publisher (
  publisher_id NUMERIC(3) PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  country VARCHAR(100)
);

CREATE TABLE board_game_store.genre (
  genre_id NUMERIC(3) PRIMARY KEY,
  genre_name VARCHAR(100) NOT NULL
);

CREATE TABLE board_game_store.game_genre (
  game_genre_id NUMERIC(3) PRIMARY KEY,
  game_id NUMERIC(3) NOT NULL,
  genre_id NUMERIC(3) NOT NULL,
  constraint fk_game_id foreign key (game_id) references board_game_store.board_game(board_id),
  constraint fk_genre_id foreign key (genre_id) references board_game_store.genre(genre_id)


);

insert into board_game_store.board_game (board_id, board_name, publisher, release_year, genre, min_players, max_players, out_of_print, play_time_minutes, age_recommendation) values (1, 'Catan', 'Catan Studio', 1995, 'Strategy', 3, 4, false, 60, 10);
insert into board_game_store.board_game (board_id, board_name, publisher, release_year, genre, min_players, max_players, out_of_print, play_time_minutes, age_recommendation) values (2, 'Ticket to Ride', 'Days of Wonder', 2004, 'Strategy', 2, 5, false, 60, 8); 