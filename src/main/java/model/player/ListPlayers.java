package model.player;

import java.util.ArrayList;

import controller.ControllerPlayer;
import games.GamePlayersProvider;
import games.IPlayerGeneral;

public class ListPlayers implements GamePlayersProvider{
 
    private ControllerPlayer controller;

    public ArrayList<IPlayerGeneral> getPlayersGeneralList(ArrayList<IPlayerGeneral> generalList, int amountPlayers){
        ArrayList<IPlayerGeneral> listPlayers = new ArrayList<>();
        controller = new ControllerPlayer(generalList);
        for (int i = 0; i < amountPlayers; i++) {
            IPlayerGeneral player = controller.getOne();
            listPlayers.add(player);
        }
        return listPlayers;
    }

}
