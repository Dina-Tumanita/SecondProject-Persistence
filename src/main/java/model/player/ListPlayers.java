package model.player;

import java.util.ArrayList;

import controller.ControllerPlayer;
import games.GamePlayersProvider;
import games.IPlayerGeneral;
import utils.Terminal;

public class ListPlayers implements GamePlayersProvider{
 
    private ControllerPlayer controller;

    public ArrayList<IPlayerGeneral> getPlayersGeneralList(ArrayList<IPlayerGeneral> generalList, int amountPlayers){
        ArrayList<IPlayerGeneral> listPlayers = new ArrayList<>();
        controller = new ControllerPlayer(generalList);
        for (int i = 0; i < amountPlayers; i++) {
            selectPlayer(listPlayers);
        }
        return listPlayers;
    }

    public void selectPlayer(ArrayList<IPlayerGeneral> listPlayers){
        IPlayerGeneral player = controller.getOne();
        if(!existPlayer(listPlayers, player)){
            listPlayers.add(player);
        } else {
            Terminal.showMessage("No se puede elegir al mismo jugador 2 veces");
            selectPlayer(listPlayers);
        }

    }

    public boolean existPlayer(ArrayList<IPlayerGeneral> listPlayers, IPlayerGeneral selected){
        for (int i = 0; i < listPlayers.size(); i++) {
            if(listPlayers.get(i).getName() == selected.getName()){
                return true;
            }
        }
        return false;
    }

}
