package games.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VerifyWinTest {

    private TicTacToe ttt;
    private Board board;
    private VerifyWin verifyWin;

    @Before
    public void initialValues(){
        this.ttt = new TicTacToe();
        this.board = new Board(this.ttt);
        this.verifyWin = new VerifyWin(this.board);
        this.board.initialValues();
    }

    @Test
    public void testVerifyWinX(){
        int posX = 0;
        int posY = 0;
        SquareValue coinPlayer = SquareValue.X;
        this.board.getBoard()[0][posY].setMyValue(coinPlayer);
        this.board.getBoard()[1][posY].setMyValue(coinPlayer);
        this.board.getBoard()[2][posY].setMyValue(coinPlayer);
        boolean valueWin = this.verifyWin.verifyWinX(posX, posY, coinPlayer);
        assertEquals(true, valueWin);
    }

    @Test
    public void testVerifyWinY(){
        int posX = 0;
        int posY = 0;
        SquareValue coinPlayer = SquareValue.X;
        this.board.getBoard()[posX][0].setMyValue(coinPlayer);
        this.board.getBoard()[posX][1].setMyValue(coinPlayer);
        this.board.getBoard()[posX][2].setMyValue(coinPlayer);
        boolean valueWin = this.verifyWin.verifyWinY(posX, posY, coinPlayer);
        assertEquals(true, valueWin);
    }

    @Test
    public void testVerifyWinXY(){
        SquareValue coinPlayer = SquareValue.X;
        this.board.getBoard()[0][0].setMyValue(coinPlayer);
        this.board.getBoard()[1][1].setMyValue(coinPlayer);
        this.board.getBoard()[2][2].setMyValue(coinPlayer);
        boolean valueWin = this.verifyWin.verifyWinXY(coinPlayer);
        assertEquals(true, valueWin);
    }

    @Test
    public void testVerifyWinYX(){
        SquareValue coinPlayer = SquareValue.X;
        this.board.getBoard()[0][2].setMyValue(coinPlayer);
        this.board.getBoard()[1][1].setMyValue(coinPlayer);
        this.board.getBoard()[2][0].setMyValue(coinPlayer);
        boolean valueWin = this.verifyWin.verifyWinYX(coinPlayer);
        assertEquals(true, valueWin);
    }


}