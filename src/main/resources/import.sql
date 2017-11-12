INSERT INTO USER (ID, VERSION, BIRTHDAY, EMAIL, NAME, PASSW, ROLE, USERNAME) VALUES (1, 1, '1995-04-12', 'alma@alma.com', 'Full Name', 'password', 'ADMIN', 'User');
INSERT INTO REQUEST (ID, VERSION, DIRECTOR, TITLE, YEAR, USER_ID) VALUES (1, 1, 'Dummy Director', 'Please make available this movie', 1993, 1);
INSERT INTO GENRE (ID,VERSION,NAME) VALUES (1,1,'HORROR');
INSERT INTO MOVIE (ID,VERSION,DESCRIPTION,DIRECTOR,GENRE_ID,TITLE,YEAR) VALUES (1,1,'This film is... zzz','Quite Good Director',1,'First movie in the db',1989);
 