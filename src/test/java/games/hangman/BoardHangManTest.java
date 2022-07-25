package games.hangman;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import games.IPlayerGeneral;
import model.player.Bot;
import model.player.Human;

public class BoardHangManTest {
    private BoardHangMan board;
    private ArrayList<IPlayerGeneral> generalList;
    

    @Before 
    public void initializeValues(){
        generalList = new ArrayList<>();
        generalList.add(new Human("humano1"));
        generalList.add(new Bot("bot1"));
        board = new BoardHangMan();

    }

    @Test
    public void testCleanBoardisNotNull() {
        board.cleanBoard();
        assertNotNull(board.getHangedMan());
    }

    @Test
    public void testEditHangedMan() {
        board.editHangedMan();
        assertNotNull(board.getHangedMan());
    }

    @Test
    public void testPrintHangMan() {

    }

    @Test
    public void testSetHangmanParts() {
        assertNotNull(board.getHangmanParts());
    }

    @Test
    public void testSetWinCondition() {
        assertNotNull(board.isWinCondition());
    }
}
