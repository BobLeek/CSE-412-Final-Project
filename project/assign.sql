-- DDL
--CSE 412 Final Project
--Due: 12/4/22
--Michael Payne
--Yue Fang
--Jesus Perez

CREATE TABLE USERS (
  EMAIL VARCHAR(255) PRIMARY KEY,
  USERNAME VARCHAR(255),
  password VARCHAR(255),
  COMMENT VARCHAR(255),
  STEAM_LEVEL VARCHAR(2),
  CONSTRAINT email_unque UNIQUE (email)
);

CREATE TABLE GAMES (
  GAME_NAME VARCHAR(255) PRIMARY KEY,
  GAME_INFO TEXT,
  CONSTRAINT game_name_unque UNIQUE (game_name)
);

CREATE TABLE GAME_HIS(
	EMAIL VARCHAR(255),
  	GAME_NAME VARCHAR(255),
  	CONSTRAINT username_game_name_unque UNIQUE (EMAIL, GAME_NAME)
);

CREATE TABLE FRIENDS (
  EMAIL VARCHAR(255),
  FRIEND_EMAIL VARCHAR(255),
  CONSTRAINT friend_unque UNIQUE (EMAIL, FRIEND_EMAIL)
);


-- insert data
INSERT INTO users VALUES ('John@gmail.com','John', '1234','John Comment','11');
INSERT INTO users VALUES ('David@gmail.com','David', '1234','David Comment','7');
INSERT INTO users VALUES ('Mary@gmail.com','Mary', '1234','Mary Comment','8');
INSERT INTO users VALUES ('Michael@gmail.com','Michael', 'password123','Profile comment','14');
INSERT INTO users VALUES ('Jeff@gmail.com', 'Jeff37', 'jeffiscool','no comment man','69');


insert into games values ('Persona 4 Golden','Persona 4, is a role-playing video game by Atlus. It is chronologically the fifth installment in the Persona series, itself a part of the larger Megami Tensei franchise.');
insert into games values ('Cities Skylines','Cities: Skylines is a 2015 city-building game developed by Colossal Order and published by Paradox Interactive. The game is a single-player open-ended city-building simulation.');
insert into games values ('Warframe','Warframe is a free-to-play action role-playing third-person shooter multiplayer online game developed and published by Digital Extremes. First released for Windows personal computers in March 2013.');
insert into games values ('Terraria','Terraria is an action-adventure sandbox game developed by Re-Logic. The game was first released for Windows on May 16, 2011, and has since been ported to several other platforms.');
insert into games values ('Overwatch 2','Overwatch 2 is a 2022 first-person shooter by Blizzard Entertainment.');
insert into games values ('Minecraft','Minecraft is a single or multiplayer sandbox game developed by Mojang Studios.');
insert into games values ('Battlefield 2042','Battlefield 2042 is a single and multiplayer first-person shooter, developed by DICE and published by Electronic Arts.');
insert into games values ('MTG Arena','MTG Arena is a free-to-play digital collectible card game developed and published by Wizards of the Coast (WotC). The game is a digital adaption based on the Magic: The Gathering (MTG) card game.');
insert into games values ('Back 4 Blood','Back 4 Blood is a first-person shooter developed by Turtle Rock Studios and published by Warner Bros. Interactive Entertainment. It was released on October 12, 2021.');
insert into games values ('GTA V','rand Theft Auto V is a 2013 action-adventure game developed by Rockstar North and published by Rockstar Games. It is the seventh main entry in the Grand Theft Auto series.');
insert into games values ('Leauge of Legends','League of Legends (LoL), commonly referred to as League, is a 2009 multiplayer online battle arena video game developed and published by Riot Games. Inspired by Defense of the Ancients, a custom map for Warcraft III.');


INSERT into game_his values ('John@gmail.com','Persona 4 Golden');
INSERT into game_his values ('John@gmail.com','Cities Skylines');
INSERT into game_his values ('John@gmail.com','Warframe');
INSERT into game_his values ('John@gmail.com','Terraria');
INSERT into game_his values ('John@gmail.com','GTA V');

INSERT into game_his values ('Mary@gmail.com','Persona 4 Golden');
INSERT into game_his values ('Mary@gmail.com','Warframe');
INSERT into game_his values ('Mary@gmail.com','Minecraft');

INSERT into game_his values ('David@gmail.com','Cities Skylines');
INSERT into game_his values ('David@gmail.com','Terraria');

INSERT into games_his values('Michael@gmail.com','Overwatch 2');
INSERT into games_his values('Michael@gmail.com','Battlefield 2042');
INSERT into games_his values('Michael@gmail.com','MTG Arena');
INSERT into games_his values('Michael@gmail.com','Back 4 Blood');

INSERT into game_his values ('Jeff@gmail.com','Persona 4 Golden');
INSERT into game_his values ('Jeff@gmail.com','Warframe');
INSERT into games_his values('Jeff@gmail.com','Battlefield 2042');
INSERT into games_his values('Jeff@gmail.com','MTG Arena');
INSERT into games_his values('Jeff@gmail.com','Leauge of Legends');


INSERT into friends values ('John@gmail.com','David@gmail.com');
INSERT into friends values ('John@gmail.com','Mary@gmail.com');
INSERT into friends values ('Mary@gmail.com','David@gmail.com');
INSERT into friends values ('Mary@gmail.com','Jeff@gmail.com');
INSERT into friends values ('Jeff@gmail.com','Michael@gmail.com');


-- insert a new user
INSERT INTO users VALUES ('Nancy@gmail.com','Nancy', '1234','Nancy Comment','1');
-- login, login success if count equals 1, else login failure
SELECT count(*) from users where email = 'Nancy@gmail.com' and password = '1234';
-- select games
SELECT * from games;
-- search emails, usernames who played game 'Warframe' 
SELECT u.email, u.username from games g join game_his gh ON g.game_name = gh.game_name 
JOIN users u ON gh.email = u.email where g.game_name = 'Warframe' ;
-- add John, Mary  as friends
INSERT into friends VALUES ('Nancy@gmail.com', 'John@gmail.com');
INSERT into friends VALUES ('Nancy@gmail.com', 'Mary@gmail.com');
INSERT into friends VALUES ('Nancy@gmail.com', 'David@gmail.com');

-- select Nancy's friends
SELECT friend_email, username from friends f join users u on f.friend_email = u.email where f.email = 'Nancy@gmail.com';
--remove John from friend list
delete from friends WHERE email = 'Nancy@gmail.com' and friend_email = 'David@gmail.com';
-- now select Nancy's friends again
SELECT u.email, u.username from friends f JOIN users u on f.email = u.email where f.email = 'Nancy@gmail.com';
-- select common friends between Nancy and John
SELECT u.email, u.username from friends f JOIN users u on f.friend_email = u.email
where f.email = 'Nancy@gmail.com' and u.email in (
SELECT u.email from friends f JOIN users u on f.friend_email = u.email
where f.email = 'John@gmail.com');

-- add game 'Persona 4 Golden' to Nancy's game library
INSERT into game_his values ('Nancy@gmail.com','Persona 4 Golden');
INSERT into game_his values ('Nancy@gmail.com','Warframe');
--select Nancy's game library
SELECT * FROM game_his where email = 'Nancy@gmail.com';
-- remove game from game library
delete from game_his where email = 'Nancy@gmail.com' and game_name = 'Persona 4 Golden';

-- update Nancy's user info
UPDATE users set comment = 'Hello, everyone.' where email = 'Nancy@gmail.com';
-- select Nancy's user info 
SELECT * from users where email = 'Nancy@gmail.com';

