package games.hangman;

import statistics.StatisticValue;
import statistics.TypeGame;

public interface IGuesserable {

    public String tryLetter();  
    public String getName();
    public void saveGameResult(TypeGame type, StatisticValue value);
 
    
}
