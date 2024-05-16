insert into USERS (password, username) values ( 'Bojana123', 'Bojana');
insert into USERS (password, username) values ( 'Filip123', 'Filip');

insert into ARTISTS (genre, password, username) values ('TECHNO', 'Andrea123', 'Andrea');

insert into ALBUMS (genre, release_date, title, artist_id) values ('TECHNO', '2023-10-20T00:00:00', 'Bojana bez Filipa', 1);

insert into SONGS (favorites_count, genre, listens_count, name, release_date, album_id, artist_id) values (100000, 'TECHNO', 412441, 'FILIPE STA BI JA BEZ TEBE NA FAKSU', '2023-10-20T00:00:00', 1, 1);
insert into SONGS (favorites_count, genre, listens_count, name, release_date, album_id, artist_id) values (500000, 'TECHNO', 4142421, 'JOJ FILIPE POMOZI MI', '2023-10-20T00:00:00', 1, 1);

insert into FAVORITE_SONGS (user_id, song_id) values ( 1, 1);
insert into FAVORITE_SONGS (user_id, song_id) values ( 2, 1);
insert into FAVORITE_SONGS (user_id, song_id) values ( 2, 2);

insert into LISTENED_SONGS (user_id, song_id) values ( 1, 1);
insert into LISTENED_SONGS (user_id, song_id) values ( 2, 1);
insert into LISTENED_SONGS (user_id, song_id) values ( 2, 1);
insert into LISTENED_SONGS (user_id, song_id) values ( 2, 2);

insert into RATED_SONGS (user_id, song_id) values ( 1, 1);
insert into RATED_SONGS (user_id, song_id) values ( 2, 2);

insert into RATINGS (comment, rating, rated_by, song_id) values ( 'Ne slazem se sa time', 3, 1, 1);
insert into RATINGS (comment, rating, rated_by, song_id) values ( 'Jaka EGZIBICIJA', 5, 2, 2);


