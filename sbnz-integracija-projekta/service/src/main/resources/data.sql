insert into USERS (password, username) values ( 'Bojana123', 'Bojana');
insert into USERS (password, username) values ( 'Filip123', 'Filip');

insert into ARTISTS (genre, password, username) values ('POP', 'Andrea123', 'Andrea');

insert into ALBUMS (genre, release_date, title, artist_id) values ('POP', '2023-10-20T00:00:00', 'Album1', 1);

insert into SONGS (favorites_count, genre, listens_count, name, release_date, album_id, artist_id) values (100000, 'POP', 412441, 'Song1', '2023-10-20T00:00:00', 1, 1);
insert into SONGS (favorites_count, genre, listens_count, name, release_date, album_id, artist_id) values (500000, 'POP', 4142421, 'Song2', '2023-10-20T00:00:00', 1, 1);
insert into SONGS (favorites_count, genre, listens_count, name, release_date, album_id, artist_id) values (100000, 'POP', 412441, 'Song3', '2023-10-20T00:00:00', 1, 1);
insert into SONGS (favorites_count, genre, listens_count, name, release_date, album_id, artist_id) values (500000, 'POP', 4142421, 'Song4', '2023-10-20T00:00:00', 1, 1);
insert into SONGS (favorites_count, genre, listens_count, name, release_date, album_id, artist_id) values (100000, 'POP', 412441, 'Song5', '2023-10-20T00:00:00', 1, 1);
insert into SONGS (favorites_count, genre, listens_count, name, release_date, album_id, artist_id) values (500000, 'POP', 4142421, 'Song6', '2023-10-20T00:00:00', 1, 1);

insert into FAVORITE_SONGS (user_id, song_id) values ( 1, 1);
insert into FAVORITE_SONGS (user_id, song_id) values ( 2, 1);
insert into FAVORITE_SONGS (user_id, song_id) values ( 2, 2);

insert into LISTENED_SONGS (user_id, song_id) values ( 1, 1);
insert into LISTENED_SONGS (user_id, song_id) values ( 2, 1);
insert into LISTENED_SONGS (user_id, song_id) values ( 2, 1);
insert into LISTENED_SONGS (user_id, song_id) values ( 2, 2);

insert into RATED_SONGS (user_id, song_id) values ( 1, 1);
insert into RATED_SONGS (user_id, song_id) values ( 2, 2);

insert into RATINGS (comment, rating, rated_by, song_id) values ( 'Not bad song', 3, 1, 1);
insert into RATINGS (comment, rating, rated_by, song_id) values ( 'My favorite song!', 5, 2, 2);


