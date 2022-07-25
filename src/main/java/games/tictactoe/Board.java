package games.tictactoe;

import utils.Terminal;

public class Board {

    public final int BOARD_SIZE = 3;
    private Square[][] myBoard = new Square[BOARD_SIZE][BOARD_SIZE];
    private TicTacToe game;
    private VerifyWin verifier = new VerifyWin(this);
    
    public Board(TicTacToe game){
        this.game = game;
    }

    public void initialValues(){
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                myBoard[i][j] = new Square();
            }
        }
    }

    public void printBoard(){
        String boardPrinted = "";
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if(myBoard[i][j].getMyValue() == SquareValue.EMPTY){
                    boardPrinted += "|   |";
                } else if(myBoard[i][j].getMyValue() == SquareValue.X){
                    boardPrinted += "| X |";
                } else if(myBoard[i][j].getMyValue() == SquareValue.O){
                    boardPrinted += "| O |";
                }
            }
            boardPrinted += "\n";
        }
        System.out.println(boardPrinted);
    }

    public Square[][] getBoard(){
        return this.myBoard;
    }

    public boolean isEmptySpaces(int contMovements){
        if(contMovements >= 9) return true;
        return false;
    }

    public boolean isTicTacToe(int posX, int posY, SquareValue value){
        return verifier.verifyWinX(posX, posY, value);
    }

    public boolean putCoin(int posX, int posY, SquareValue value){
        if(myBoard[posX][posY].getMyValue() == SquareValue.EMPTY){
            myBoard[posX][posY].setMyValue(value);
        } else {
            Terminal.showMessage("Invalid move");
            if(this.game.getContMovements() < 8) return false;
        }
        return true;
    }

}
