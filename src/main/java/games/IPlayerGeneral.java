package games;
import games.hangman.IHangmanPlayer;
import games.tictactoe.ITTTPlayer;
import games.tictactoe.SquareValue;
import statistics.StatisticValue;
import statistics.TypeGame;

public interface IPlayerGeneral extends ITTTPlayer, IHangmanPlayer {

    public void saveGameResult(TypeGame type, StatisticValue value);
    public String getName();
    public void setName(String name);
    public SquareValue getCoinTTT();
    public void setCoinTTT(SquareValue value);
    public void showStatistics();

}
