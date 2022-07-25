package games;

import java.util.ArrayList;
public interface GamePlayersProvider {
public ArrayList<IPlayerGeneral> getPlayersGeneralList(ArrayList<IPlayerGeneral> generalList, int amountPlayers);
    
}
