--  Tables creation
CREATE SCHEMA IF NOT EXISTS song_matcher;

CREATE SEQUENCE song_matcher.album_sequence
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE song_matcher.song_sequence
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE song_matcher.artist_sequence
    START WITH 1
    INCREMENT BY 1;

CREATE SEQUENCE song_matcher.fingerprint_sequence
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE song_matcher.Album (
    id INT PRIMARY KEY,
    title VARCHAR(100),
    description VARCHAR(100),
    icon VARCHAR
);

CREATE TABLE song_matcher.Song (
    id INT PRIMARY KEY,
    title VARCHAR(100),
    duration TIME,
    type VARCHAR(100),
    description VARCHAR(100),
    certification VARCHAR(100)
);

CREATE TABLE song_matcher.Fingerprint (
    fingerprint_id INTEGER PRIMARY KEY,
    invariant_component DOUBLE PRECISION,
    variant_component DOUBLE PRECISION,
    localisation DOUBLE PRECISION,
    song_id INTEGER,
    FOREIGN KEY (song_id) REFERENCES song_matcher.Song(id)
);

CREATE TABLE song_matcher.Artist (
    id INTEGER PRIMARY KEY,
    name VARCHAR(100),
    description VARCHAR(100),
    certification VARCHAR(255)
);

CREATE TABLE song_matcher.Realise_Album (
    album_id INT,
    artist_id INT,
    FOREIGN KEY (album_id) REFERENCES song_matcher.Album(id),
    FOREIGN KEY (artist_id) REFERENCES song_matcher.Artist(id),
    PRIMARY KEY (album_id, artist_id)
);

CREATE TABLE song_matcher.Realise_Song (
    song_id INT,
    artist_id INT,
    FOREIGN KEY (song_id) REFERENCES song_matcher.Song(id),
    FOREIGN KEY (artist_id) REFERENCES song_matcher.Artist(id),
    PRIMARY KEY (song_id, artist_id)
);

CREATE TABLE song_matcher.Include_Song (
    song_id INT,
    album_id INT,
    FOREIGN KEY (song_id) REFERENCES song_matcher.Song(id),
    FOREIGN KEY (album_id) REFERENCES song_matcher.Album(id),
    PRIMARY KEY (song_id, album_id)
);

CREATE INDEX idx_fingerprint_invariant_component
ON song_matcher.Fingerprint (invariant_component);

-- Insertion
INSERT INTO song_matcher.Song VALUES (nextval('song_matcher.song_sequence') , 'Thunderstruck', '00:05:00', 'tock', 'musique de rock', 'gold');
INSERT INTO song_matcher.Song VALUES (nextval('song_matcher.song_sequence'), 'Houdini', '00:05:30', 'rap', 'musique de rap', 'platine');
INSERT INTO song_matcher.Song VALUES (nextval('song_matcher.song_sequence'), 'Gitano', '00:03:00', 'flamenco', 'musique flamenco', 'gold');

INSERT INTO song_matcher.Album VALUES (nextval('song_matcher.album_sequence'), 'The razors edge', 'album AC DC', 'album1 icon');
INSERT INTO song_matcher.Album VALUES (nextval('song_matcher.album_sequence'), 'The Death of Slim Shady', 'album eminem', 'album2 icon');
INSERT INTO song_matcher.Album VALUES (nextval('song_matcher.album_sequence'), 'Kendji', 'album kendji', 'album3 icon');

INSERT INTO song_matcher.Artist VALUES (nextval('song_matcher.artist_sequence'), 'AC DC', 'groupe de rock');
INSERT INTO song_matcher.Artist VALUES (nextval('song_matcher.artist_sequence'), 'Eminem', 'rappeur américain');
INSERT INTO song_matcher.Artist VALUES (nextval('song_matcher.artist_sequence'), 'Kendji Girac', 'chanteur français');

INSERT INTO song_matcher.Realise_Album VALUES (1, 1);
INSERT INTO song_matcher.Realise_Album VALUES (2, 2);
INSERT INTO song_matcher.Realise_Album VALUES (3, 3);

INSERT INTO song_matcher.Realise_Song VALUES (1, 1);
INSERT INTO song_matcher.Realise_Song VALUES (2, 2);
INSERT INTO song_matcher.Realise_Song VALUES (3, 3);

INSERT INTO song_matcher.Include_Song VALUES (1, 1);
INSERT INTO song_matcher.Include_Song VALUES (2, 2);
INSERT INTO song_matcher.Include_Song VALUES (3, 3);
