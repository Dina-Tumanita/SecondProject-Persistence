-- Listado de jugadores que al menos han jugado una partida
SELECT *
FROM player
WHERE gamesplayed >= 1 ;

-- Listado de jugadores que no han jugado una partida
SELECT *
FROM player
WHERE gamesplayed = 0 ;

-- Listado de jugadores que al menos han ganado una partida
SELECT player.playerid, player.name, playerstats.win
FROM player
INNER JOIN playerstats ON player.playerid = playerstats.playerid
WHERE playerstats.win > 0;

-- Listado de Jugadores que no han perdido una partida
SELECT player.playerid, player.name, playerstats.loss
FROM player
INNER JOIN playerstats ON player.playerid = playerstats.playerid
WHERE playerstats.loss = 0;

-- Top 3 de los peores jugadores (partidas perdidas)
SELECT *
FROM (SELECT player.playerid, player.name,  playerstats.loss FROM player INNER JOIN playerstats ON player.playerid = playerstats.playerid order by  playerstats.loss desc)  
WHERE ROWNUM <= 3 --ORDER BY playerstats.loss DESC

-- Top 3 de los mejores jugadores (partidas ganadas)
SELECT *
FROM (SELECT player.playerid, player.name,  playerstats.win FROM player INNER JOIN playerstats ON player.playerid = playerstats.playerid order by  playerstats.win desc)  
WHERE ROWNUM <= 3 

-- Top 3 de los mejores jugadores hangman
SELECT player.name, wins, bestHMplayers
FROM (SELECT DISTINCT turnhm.winner AS bestHMplayers, MAX (COUNT (*)) OVER (PARTITION BY turnhm.winner) AS wins
    FROM turnhm
    WHERE turnhm.winner > 0
    GROUP BY turnhm.winner
    ORDER BY wins DESC)
INNER JOIN player ON player.playerid = bestHMplayers 
WHERE ROWNUM <= 3 

-- Top 3 de los mejores jugadores ttt
SELECT player.name, wins, bestTTTplayers
FROM (SELECT DISTINCT turnttt.winner AS bestTTTplayers, MAX (COUNT (*)) OVER (PARTITION BY turnttt.winner) AS wins
    FROM turnttt
    WHERE turnttt.winner > 0
    GROUP BY turnttt.winner
    ORDER BY wins DESC)
INNER JOIN player ON player.playerid = bestTTTplayers 
WHERE ROWNUM <= 3 

-- Top 3 de los peores jugadores hangman
SELECT player.name, losses, worstTTTplayers
FROM (SELECT DISTINCT turnttt.loser AS worstTTTplayers, MAX (COUNT (*)) OVER (PARTITION BY turnttt.loser) AS losses
    FROM turnttt
    WHERE turnttt.loser > 0
    GROUP BY turnttt.loser
    ORDER BY losses DESC)
INNER JOIN player ON player.playerid = worstTTTplayers 
WHERE ROWNUM <= 3 

-- Top 3 de los peores jugadores ttt
SELECT player.name, losses, worstHMplayers
FROM (SELECT DISTINCT turnhm.loser AS worstHMplayers, MAX (COUNT (*)) OVER (PARTITION BY turnhm.loser) AS losses
    FROM turnhm
    WHERE turnhm.loser > 0
    GROUP BY turnhm.loser
    ORDER BY losses DESC)
INNER JOIN player ON player.playerid = worstHMplayers 
WHERE ROWNUM <= 3 

-- Jugador de TTT con menos tiros para ganar
SELECT player.playerid, player.name, leastamountofturns
FROM (SELECT turnttt.tttid, MAX (tictactoeboard.tttboardid) AS leastamountofturns, turnttt.winner
    FROM turnttt
    INNER JOIN tictactoeboard ON turnttt.tttid = tictactoeboard.tttid 
    WHERE turnttt.winner > 0 
    GROUP BY turnttt.tttid, turnttt.winner
    ORDER BY leastamountofturns ASC)
INNER JOIN player ON player.playerid = winner
WHERE ROWNUM <= 1
GROUP BY player.playerid, player.name, leastamountofturns

-- Jugador de Hangman con menos intentos al ganar
SELECT player.playerid, player.name, leastamountofturns
FROM (SELECT turnhm.hmid, MAX (hangmanboard.hmboardid) AS leastamountofturns, turnhm.winner
    FROM turnhm
    INNER JOIN hangmanboard ON turnhm.hmid = hangmanboard.hmid 
    WHERE turnhm.winner > 0 
    GROUP BY turnhm.hmid, turnhm.winner
    ORDER BY leastamountofturns ASC)
INNER JOIN player ON player.playerid = winner
WHERE ROWNUM <= 1
GROUP BY player.playerid, player.name, leastamountofturns

-- Jugador de TTT con más tiros para ganar
SELECT player.playerid, player.name, mostamountofturns
FROM (SELECT turnttt.tttid, MAX (tictactoeboard.tttboardid) AS mostamountofturns, turnttt.winner
    FROM turnttt
    INNER JOIN tictactoeboard ON turnttt.tttid = tictactoeboard.tttid 
    WHERE turnttt.winner > 0 
    GROUP BY turnttt.tttid, turnttt.winner
    ORDER BY mostamountofturns DESC)
INNER JOIN player ON player.playerid = winner
WHERE ROWNUM <= 1
GROUP BY player.playerid, player.name, mostamountofturns

-- Jugador de Hangman con más intentos para ganar
SELECT player.playerid, player.name, mostamountofturns
FROM (SELECT turnhm.hmid, MAX (hangmanboard.hmboardid) AS mostamountofturns, turnhm.winner
    FROM turnhm
    INNER JOIN hangmanboard ON turnhm.hmid = hangmanboard.hmid 
    WHERE turnhm.winner > 0 
    GROUP BY turnhm.hmid, turnhm.winner
    ORDER BY mostamountofturns DESC)
INNER JOIN player ON player.playerid = winner
WHERE ROWNUM <= 1
GROUP BY player.playerid, player.name, mostamountofturns

-- Promedio de tiros en TTT para ganar una partida ( partidas empatadas y en progreso no cuentan)
SELECT ROUND(AVG( maxturns ), 2)/2 averagethrows
FROM(SELECT turnttt.tttid, MAX (tictactoeboard.tttboardid) AS maxturns
    FROM turnttt
    INNER JOIN tictactoeboard ON turnttt.tttid = tictactoeboard.tttid
    WHERE turnttt.finished != 0 AND turnttt.winner != 0
    GROUP BY turnttt.tttid
    ORDER BY maxturns DESC)

-- Promedio del tamaño de palabras utilizadas en Hangman
SELECT  ROUND(AVG( VSIZE (secretword) ), 2) averagewordsize 
FROM hangmanword;

-- Mostrar Listado de los jugadores de Hangman y establecer si son mejores como guiver o guesser
SELECT * 
FROM (SELECT playerid, COL FROM hangman
    UNPIVOT (playerid FOR COL IN (giverid, guesserid)))
    PIVOT(COUNT(*) for (col) in ('GIVERID' playedasgiver, 'GUESSERID' playedasguesser))

-- Mostrar listado de los jugadores de TTT y mostrar si son mejores con las X o las O
SELECT playerid, playedasx, playedaso
FROM (SELECT playerid, COL FROM tictactoe
    UNPIVOT (playerid FOR COL IN (playerxid, playeroid)))
    PIVOT(COUNT(*) for (col) in ('PLAYERXID' playedasx, 'PLAYEROID' playedaso))
INNER JOIN turnttt ON playerid = turnttt.winner
WHERE playerid = turnttt.winner

        -- ----------SHOWS PLAYED FOR EACH ROLE PER PLAYER TTT
SELECT * 
FROM (SELECT playerid, COL FROM tictactoe
    UNPIVOT (playerid FOR COL IN (playerxid, playeroid)))
    PIVOT(COUNT(*) for (col) in ('PLAYERXID' playedasx, 'PLAYEROID' playedaso))

        -- ----------SHOWS WINS AND LOSSES PER PLAYER TTT
SELECT * 
FROM (SELECT playerid, COL FROM turnttt
    UNPIVOT (playerid FOR COL IN (winner, loser)))
    PIVOT(COUNT(*) for (col) in ('WINNER' won, 'LOSER' lost))
WHERE playerid != 0
