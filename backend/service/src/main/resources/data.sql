--regular users
--pass: marko123
insert into USERS(first_name, last_name, password, role, username) values ('Marko', 'Markovic', '$2a$10$lu4v7hqfpCpuiCCfw6L8QuLjSfXQUjWH7Fw9nCreHTw3yGqMB0g4i', 'REGULAR_USER', 'marko.markovic');
insert into REGULAR_USERS(id) values (1);
insert into USER_PREFERENCES(user_id) values (1);
--pass: pera123
insert into USERS(first_name, last_name, password, role, username) values ('Pera', 'Peric', '$2a$10$XJWEds0tl4Xh1tfGvEDW3.25DzqsReOUvUfl9od3RIW9IcUU.JZ1W', 'REGULAR_USER', 'pera.peric');
insert into REGULAR_USERS(id) values (2);
insert into USER_PREFERENCES(user_id) values (2);
--pass: jovana123
insert into USERS(first_name, last_name, password, role, username) values ('Jovana', 'Jovanovic', '$2a$10$4PvFy4jQo4np9GGQTTLqn.RqdghBboO6BQ3bxicym.mmgdUCoipRa', 'REGULAR_USER', 'jovana.jovanovic');
insert into REGULAR_USERS(id) values (3);
insert into USER_PREFERENCES(user_id) values (3);

--genres
insert into GENRES(genre) values ('Pop');
insert into GENRES(genre) values ('Rock');
insert into GENRES(genre) values ('Hip hop');
insert into GENRES(genre) values ('Electronic');
insert into GENRES(genre) values ('Classical');
insert into GENRES(genre) values ('Jazz');
insert into GENRES(genre) values ('Reggae');
insert into GENRES(genre) values ('Country');
insert into GENRES(genre) values ('Metal');
insert into GENRES(genre) values ('Indie');
insert into GENRES(genre) values ('Rnb');
insert into GENRES(genre) values ('EDM');
insert into GENRES(genre) values ('Techno');

--artists
--pass: billie123
insert into USERS(first_name, last_name, password, role, username) values ('Billie', 'Eilish', '$2a$10$c3wosHjy9hb1R28eUw7w0eNJHVLVeKhAm13o1khJ/b9SduEckKECO', 'ARTIST', 'billie.eilish');
insert into ARTISTS(id, genre_id) values (4, 1);
--pass: taylor123
insert into USERS(first_name, last_name, password, role, username) values ('Taylor', 'Swift', '$2a$10$uKSXhUcityKZbGjFnpTARuDdzD0el5T0ja4nEI.OhPvDogFYZRdUa', 'ARTIST', 'taylor.swift');
insert into ARTISTS(id, genre_id) values (5, 1);
--pass: sabrina123
insert into USERS(first_name, last_name, password, role, username) values ('Sabrina', 'Carpenter', '$2a$10$BbOjI5u6K0sctSFnlfiWLueW.xv1qP3RNS7slkI5iT0gYtzXTsP/i', 'ARTIST', 'sabrina.carpenter');
insert into ARTISTS(id, genre_id) values (6, 1);

--albums
insert into ALBUMS(release_date, title, artist_id, genre_id) values ('2024-05-17', 'Hit Me Hard and Soft', 4, 1);
insert into ALBUMS(release_date, title, artist_id, genre_id) values ('2022-10-21', 'Midnights', 5, 1);
insert into ALBUMS(release_date, title, artist_id, genre_id) values ('2022-07-15', 'Emails I Cant Send', 6, 1);

--songs
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '3:39', 0, 'Skinny', 1, 4, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '3:00', 0, 'Lunch', 1, 4, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '5:03', 0, 'Chihiro', 1, 4, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '3:30', 0, 'Birds of a Feather', 1, 4, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '4:21', 0, 'Wildflower', 1, 4, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '4:53', 0, 'The Greatest', 1, 4, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '5:33', 0, 'L Amour de Ma Vie', 1, 4, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '3:06', 0, 'The Diner', 1, 4, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '4:58', 0, 'Bittersuite', 1, 4, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '5:43', 0, 'Blue', 1, 4, 1);

insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '3:22', 0, 'Lavender Haze', 2, 5, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '3:38', 0, 'Maroon', 2, 5, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '3:20', 0, 'Anti-Hero', 2, 5, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '4:16', 0, 'Snow on the Beach', 2, 5, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '3:14', 0, 'You re on Your Own, Kid', 2, 5, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '2:54', 0, 'Midnight Rain', 2, 5, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '3:30', 0, 'Question...?', 2, 5, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '2:44', 0, 'Vigilante Shit', 2, 5, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '3:14', 0, 'Bejeweled', 2, 5, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '4:07', 0, 'Labyrinth', 2, 5, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '3:24', 0, 'Karma', 2, 5, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '3:08', 0, 'Sweet Nothing', 2, 5, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '3:11', 0, 'Mastermind', 2, 5, 1);

insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '1:44', 0, 'Emails I Can''t Send', 3, 6, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '2:29', 0, 'Vicious', 3, 6, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '3:27', 0, 'Read Your Mind', 3, 6, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '3:24', 0, 'Tornado Warnings', 3, 6, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '3:16', 0, 'Because I Liked a Boy', 3, 6, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '2:50', 0, 'Already Over', 3, 6, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '4:03', 0, 'How Many Things', 3, 6, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '3:11', 0, 'Bet U Wanna', 3, 6, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '2:43', 0, 'Nonsense', 3, 6, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '2:54', 0, 'Fast Times', 3, 6, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '2:57', 0, 'Skinny Dipping', 3, 6, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '3:08', 0, 'Bad for Business', 3, 6, 1);
insert into SONGS(favorites_count, length,  listens_count, name, album_id, artist_id, genre_id) values (0, '3:08', 0, 'Decode', 3, 6, 1);