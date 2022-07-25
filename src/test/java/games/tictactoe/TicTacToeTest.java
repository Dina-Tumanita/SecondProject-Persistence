package games.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    private TicTacToe ttt;

    @Before
    public void initialValues(){
        ttt = new TicTacToe();
    }

    @Test
    public void testGiveCoinX(){
        int indexPlayer = 2;
        SquareValue coinPlayer = ttt.giveCoin(indexPlayer);
        assertEquals(SquareValue.X, coinPlayer);
    }

    @Test
    public void testGiveCoinO(){
        int indexPlayer = 1;
        SquareValue coinPlayer = ttt.giveCoin(indexPlayer);
        assertEquals(SquareValue.O, coinPlayer);
    }

}