package games.tictactoe;

public class Square {
    
    SquareValue myValue = SquareValue.EMPTY;

    public void setMyValue(SquareValue myValue){
        this.myValue = myValue;
    }

    public SquareValue getMyValue(){
        return this.myValue;
    }

}
