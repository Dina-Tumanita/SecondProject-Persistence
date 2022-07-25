package games.tictactoe;

import games.IPlayerGeneral;
import model.player.Bot;
import model.player.Human;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;
    private ArrayList<IPlayerGeneral> generalList;

    private TicTacToe ttt;

    @Before
    public void initialValues(){
        generalList = new ArrayList<>();
        generalList.add(new Human("humano1"));
        generalList.add(new Bot("bot1"));
        ttt = new TicTacToe();
        board = new Board(this.ttt);
    }

    @Test
    public void testInitialValuesIsNotNull(){
        board.initialValues();
        assertNotNull(board.getBoard()[0][0]);
    }

    @Test
    public void testInitialValuesIsEmpty(){
        board.initialValues();
        assertEquals(SquareValue.EMPTY, board.getBoard()[0][0].getMyValue());
    }

    @Test
    public void testBoardSize(){
        assertEquals(3, board.BOARD_SIZE);
    }

    @Test
    public void testEmptySpacesIsTrue(){
        int contMovements = 9;
        boolean emptySpaces = board.isEmptySpaces(contMovements);
        assertEquals(true, emptySpaces);
    }

    @Test
    public void testEmptySpacesIsFalse(){
        int contMovements = 1;
        boolean emptySpaces = board.isEmptySpaces(contMovements);
        assertEquals(false, emptySpaces);
    }

    @Test
    public void testPutCoinInInvalidPosition(){
        int posX = 2;
        int posY = 2;
        SquareValue coinPlayer = SquareValue.O;
        this.board.initialValues();
        this.board.getBoard()[posX][posY].setMyValue(SquareValue.X);
        boolean valuePut = this.board.putCoin(posX, posY, coinPlayer);
        assertEquals(false, valuePut);
    }

    @Test
    public void testPutCoinIsCorrect(){
        int posX = 2;
        int posY = 2;
        SquareValue coinPlayer = SquareValue.O;
        this.board.initialValues();
        boolean valuePut = this.board.putCoin(posX, posY, coinPlayer);
        assertEquals(true, valuePut);
    }



}