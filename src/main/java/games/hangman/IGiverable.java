package games.hangman;

import statistics.StatisticValue;
import statistics.TypeGame;

public interface IGiverable {    
    
    public String selectWord();
    public String getName();
    public void saveGameResult(TypeGame type, StatisticValue value);

}
