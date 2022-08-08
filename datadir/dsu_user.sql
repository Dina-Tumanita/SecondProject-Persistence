CREATE TABLE GAME (gameid number, name varchar(20), numplayers number, round number, primary key (gameid)) ;
CREATE TABLE GAMESTATS (gameid number, played number, foreign key (gameid) references GAME(gameid)) ;

CREATE TABLE PLAYER (playerid number, name varchar(20), gamesplayed number,  primary key (playerid)) ;
CREATE TABLE PLAYERSTATS (playerid number, gameid number, win number, loss number, tie number, foreign key (playerid) references PLAYER(playerid));

CREATE TABLE TICTACTOE (tttid number, gameid number, playerXid number, playerOid number, primary key (tttid), foreign key (gameid) references GAME(gameid), foreign key (playerXid) references PLAYER(playerid), foreign key (playerOid) references PLAYER(playerid)) ;
CREATE TABLE TURNTTT(idturnttt number, tttid number, finished CHAR(1), winner number, primary key (idturnttt), foreign key (tttid) references TICTACTOE(tttid)) ;
CREATE TABLE TICTACTOEBOARD (boardid number, tttid number, idturnttt number, x number, y number, type varchar(1), primary key (boardid), foreign key (tttid) references TICTACTOE(tttid), foreign key (idturnttt) references TURNTTT(idturnttt)) ;

CREATE TABLE HANGMAN (hmid number, gameid number, giverid number, guesserid number, primary key (hmid), foreign key (gameid) references GAME(gameid), foreign key (giverid) references PLAYER(playerid), foreign key (guesserid) references PLAYER(playerid)) ;
CREATE TABLE TURNHM(idturnhm number, hmid number, finished CHAR(1), winner number, primary key (idturnhm), foreign key (hmid) references HANGMAN(hmid)) ;
CREATE TABLE HANGMANWORD (hmid number, secretword varchar(20), guessedletters varchar(26), hintgiven char(1), primary key (hmid), foreign key (hmid) references HANGMAN(hmid)) ;
CREATE TABLE HANGMANBOARD (hmboardid number, hmid number, idturnhm number, guessingletter char, remainingattempts number, primary key (hmboardid), foreign key (hmid) references HANGMAN(hmid), foreign key (idturnhm) references TURNHM(idturnhm)) ;


ALTER TABLE gamestats
ADD gamestatsid number;

ALTER TABLE gamestats
ADD PRIMARY KEY (gamestatsid);

 DROP TABLE PLAYERSTATS;

commit;

desc game;
desc gamestats;
desc player;
desc playerstats;
desc tictactoe;
desc turnttt;
desc tictactoeboard;
desc hangman;
desc turnhm;
desc hangmanword;
desc hangmanboard;


