package games;

import java.util.ArrayList;

import model.player.ListPlayers;
public abstract class Game {

    public ArrayList<IPlayerGeneral> players;
    private ArrayList<IPlayerGeneral> generalList;
    private int totalPlayers;
    public GamePlayersProvider listProviders;

    public Game(ArrayList<IPlayerGeneral> generalList, int totalPlayers) {
        this.listProviders = new ListPlayers();
        this.generalList = generalList;
        this.totalPlayers = totalPlayers;
    }

    public Game(){}

    public void selectPlayer(GamePlayersProvider listProviders) {
        players = listProviders.getPlayersGeneralList(this.generalList, this.totalPlayers);
    }

    public abstract void go();

    public abstract void turn();

}
