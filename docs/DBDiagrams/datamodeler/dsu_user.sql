SELECT name, gamesplayed AS MAX_gameplayed
FROM player
WHERE gamesplayed = (SELECT MAX(gamesplayed) FROM player);
