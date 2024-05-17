insert into GENRES(genre) values ('POP');
insert into GENRES(genre) values ('ROCK');
insert into GENRES(genre) values ('HIP HOP');
insert into GENRES(genre) values ('ELECTRONIC');
insert into GENRES(genre) values ('CLASSICAL');
insert into GENRES(genre) values ('JAZZ');
insert into GENRES(genre) values ('REGGAE');
insert into GENRES(genre) values ('COUNTRY');
insert into GENRES(genre) values ('METAL');
insert into GENRES(genre) values ('INDIE');
insert into GENRES(genre) values ('RNB');
insert into GENRES(genre) values ('EDM');
insert into GENRES(genre) values ('TECHNO');

insert into USERS (password, username) values ( 'Bojana123', 'Bojana');
insert into USERS (password, username) values ( 'Filip123', 'Filip');

insert into ARTISTS (genre_id, password, username) values (1, 'Andrea123', 'Andrea');

insert into ALBUMS (genre_id, release_date, title, artist_id) values (1, '2023-10-20T00:00:00', 'Album1', 1);

insert into SONGS (favorites_count, genre_id, listens_count, name, release_date, album_id, artist_id) values (100000, 1, 412441, 'Song1', '2023-10-20T00:00:00', 1, 1);
insert into SONGS (favorites_count, genre_id, listens_count, name, release_date, album_id, artist_id) values (500000, 1, 4142421, 'Song2', '2023-10-20T00:00:00', 1, 1);
insert into SONGS (favorites_count, genre_id, listens_count, name, release_date, album_id, artist_id) values (100000, 1, 412441, 'Song3', '2023-10-20T00:00:00', 1, 1);
insert into SONGS (favorites_count, genre_id, listens_count, name, release_date, album_id, artist_id) values (500000, 1, 4142421, 'Song4', '2023-10-20T00:00:00', 1, 1);
insert into SONGS (favorites_count, genre_id, listens_count, name, release_date, album_id, artist_id) values (100000, 1, 412441, 'Song5', '2023-10-20T00:00:00', 1, 1);
insert into SONGS (favorites_count, genre_id, listens_count, name, release_date, album_id, artist_id) values (500000, 1, 4142421, 'Song6', '2023-10-20T00:00:00', 1, 1);

-- insert into FAVORITE_SONGS (user_id, song_id) values ( 1, 1);
-- insert into FAVORITE_SONGS (user_id, song_id) values ( 2, 1);
-- insert into FAVORITE_SONGS (user_id, song_id) values ( 2, 2);
--
-- insert into LISTENED_SONGS (user_id, song_id) values ( 1, 1);
-- insert into LISTENED_SONGS (user_id, song_id) values ( 2, 1);
-- insert into LISTENED_SONGS (user_id, song_id) values ( 2, 1);
-- insert into LISTENED_SONGS (user_id, song_id) values ( 2, 2);
--
-- insert into RATED_SONGS (user_id, song_id) values ( 1, 1);
-- insert into RATED_SONGS (user_id, song_id) values ( 2, 2);

insert into RATINGS (comment, rating, rated_by, song_id) values ( 'Not bad song', 3, 1, 1);
insert into RATINGS (comment, rating, rated_by, song_id) values ( 'My favorite song!', 5, 2, 2);


