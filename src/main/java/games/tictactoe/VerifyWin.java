package games.tictactoe;

public class VerifyWin {

    private Board board;

    public VerifyWin(Board board){
        this.board = board;
    }

    public boolean verifyWinX(int posX, int posY, SquareValue value){
        int auxX = 0;
        while(auxX < board.BOARD_SIZE){
            if(auxX != posX){
                if(board.getBoard()[auxX][posY].getMyValue() != value)
                    return verifyWinY(posX, posY, value);
            }
            auxX++;
        }
        return true;
    }

    public boolean verifyWinY(int posX, int posY, SquareValue value){
        int auxY = 0;
        while(auxY < board.BOARD_SIZE){
            if(auxY != posY){
                if(board.getBoard()[posX][auxY].getMyValue() != value)
                    return verifyWinXY(value);
            }
            auxY++;
        }
        return true;
    }

    public boolean verifyWinXY(SquareValue value){
        int auxX = 0, auxY = 0;
        while(auxX < board.BOARD_SIZE && auxY < board.BOARD_SIZE){
            if(board.getBoard()[auxX][auxY].getMyValue() != value)
                return verifyWinYX(value);
            auxX++; auxY++;
        }
        return true;
    }

    public boolean verifyWinYX(SquareValue value){
        int auxX = 0, auxY = 2;
        while(auxX < board.BOARD_SIZE && auxY < board.BOARD_SIZE){
            if(board.getBoard()[auxX][auxY].getMyValue() != value)
                return false;
            auxX++; auxY--;
        }
        return true;
    }

}
