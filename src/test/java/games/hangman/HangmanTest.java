package games.hangman;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import games.IPlayerGeneral;
import model.player.Bot;

public class HangmanTest {  
    private Hangman HM;
    private ArrayList<IPlayerGeneral> playerList = new ArrayList<>();


    @Before 
    public void initializeValues(){
        HM = new Hangman();
    }


    @Test
    public void testTurn() {   
        HM.player1 = new Bot("bot1"); 
        HM.player2 = new Bot("bot1");  
        assertNotNull(HM.player1);
        assertNotNull(HM.player2);
    }
}
