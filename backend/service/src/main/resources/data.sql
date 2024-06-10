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
insert into GENRES(genre) values ('Soul');
insert into GENRES(genre) values ('Ambient');

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
--pass: pharrell123
insert into USERS(first_name, last_name, password, role, username) values ('Pharrell', 'Williams', '$2a$10$uveldVPW97lKJ9yI1JJ9det/jDgjzjUTe6TdkOM/.Q0IpupXhIT0q', 'ARTIST', 'pharrell');
insert into ARTISTS(id, genre_id) values (7, 14);
--pass: adele123
insert into USERS(first_name, last_name, password, role, username) values ('Adele', 'Adkins', '$2a$10$vRsFHq6gc9jmV70CT9qIL.HPurb6ng6qs8c6nK9u8lfRce4W1Yv82', 'ARTIST', 'adele');
insert into ARTISTS(id, genre_id) values (8, 1);
--pass: survivor123
insert into USERS(first_name, last_name, password, role, username) values ('Survivor', '', '$2a$10$U1FzUnqMBXHHyAA0kGwjsulZYfwLxavZCxeaP/E4ebAJy2Z28Ebj6', 'ARTIST', 'survivor');
insert into ARTISTS(id, genre_id) values (9, 2);
--pass: marconi123
insert into USERS(first_name, last_name, password, role, username) values ('Marconi', 'Union', '$2a$10$7YQCEHugD0tIdP002XUjpeO3KhSkooYCrTCSIl4ApYgdgczKCk3Ku', 'ARTIST', 'marconi.union');
insert into ARTISTS(id, genre_id) values (10, 15);
--pass: ed123
insert into USERS(first_name, last_name, password, role, username) values ('Ed', 'Sheeran', '$2a$10$S0YHPuxCWC8G7Z8zs9h/p.g9ZJRBwJnl6IcwQErq5fx.GCBSbVSdy', 'ARTIST', 'ed.sheeran');
insert into ARTISTS(id, genre_id) values (11, 1);
--pass: eminem123
insert into USERS(first_name, last_name, password, role, username) values ('Marshall Bruce', 'Mathers', '$2a$10$hNzhD3MHvABxZK3Dh0/5tuptujA3rua0/p0PbwukFlW23yp00jiQa', 'ARTIST', 'eminem');
insert into ARTISTS(id, genre_id) values (12, 3);
--pass: thebeatles123
insert into USERS(first_name, last_name, password, role, username) values ('The', 'Beatles', '$2a$10$arB77fKSF5M38fo91QqSMOrRCLzsgz4j5UnIMUaYQwu6kdGT4UEEe', 'ARTIST', 'the.beatles');
insert into ARTISTS(id, genre_id) values (13, 2);
--pass: bruno123
insert into USERS(first_name, last_name, password, role, username) values ('Bruno', 'Mars', '$2a$10$hjM2dHkw/tCu5ZR7NfEfu.UhjfZzK62h5e20zE.nuW9dRgq0UTNBi', 'ARTIST', 'bruno.mars');
insert into ARTISTS(id, genre_id) values (14, 1);
--pass: imaginedragons123
insert into USERS(first_name, last_name, password, role, username) values ('Imagine', 'Dragons', '$2a$10$RHcMnwXnryERjEBTesER/OLrx25n74fyaLEJ2AMNL.M7mVGONwAhC', 'ARTIST', 'imagine.dragons');
insert into ARTISTS(id, genre_id) values (15, 1);
--pass: coldplay123
insert into USERS(first_name, last_name, password, role, username) values ('Coldplay', '', '$2a$10$UHZ3pqtzxIQMIuVaUyfxTuXIzxC8ZVTyrFB6VaMbLk1I.rNcVLTxK', 'ARTIST', 'coldplay');
insert into ARTISTS(id, genre_id) values (16, 2);

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

insert into SONGS(favorites_count, length,  listens_count, name, artist_id, genre_id) values (0, '3:55', 0, 'Happy', 7, 14);
insert into SONGS(favorites_count, length,  listens_count, name, artist_id, genre_id) values (0, '4:45', 0, 'Someone Like You', 8, 1);
insert into SONGS(favorites_count, length,  listens_count, name, artist_id, genre_id) values (0, '4:04', 0, 'Eye of the Tiger', 9, 2);
insert into SONGS(favorites_count, length,  listens_count, name, artist_id, genre_id) values (0, '8:09', 0, 'Weightless', 10, 15);
insert into SONGS(favorites_count, length,  listens_count, name, artist_id, genre_id) values (0, '4:23', 0, 'Perfect', 11, 1);
insert into SONGS(favorites_count, length,  listens_count, name, artist_id, genre_id) values (0, '5:20', 0, 'Lose Yourself', 12, 3);
insert into SONGS(favorites_count, length,  listens_count, name, artist_id, genre_id) values (0, '4:03', 0, 'Let It Be', 13, 2);
insert into SONGS(favorites_count, length,  listens_count, name, artist_id, genre_id) values (0, '4:30', 0, 'Uptown Funk', 14, 1);
insert into SONGS(favorites_count, length,  listens_count, name, artist_id, genre_id) values (0, '3:12', 0, 'On Top of the World', 15, 1);
insert into SONGS(favorites_count, length,  listens_count, name, artist_id, genre_id) values (0, '4:54', 0, 'Fix You', 16, 2);
