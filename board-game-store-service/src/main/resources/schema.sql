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

CREATE TABLE board_game_store.game_genres (
  game_id INT REFERENCES board_game_store.board_game(board_id),
  genre_id INT REFERENCES board_game_store.genres(id),
  PRIMARY KEY (game_id, genre_id)
);