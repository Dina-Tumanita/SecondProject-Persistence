package model.player;

import java.util.ArrayList;

import games.IPlayerGeneral;
import games.tictactoe.SquareValue;
import statistics.Statistic;
import statistics.StatisticValue;
import statistics.StatisticsPlayer;
import statistics.TypeGame;
import utils.Terminal;

public abstract class Player implements IPlayerGeneral {
    
    private String name;
    private StatisticsPlayer myStatistics = new StatisticsPlayer();

    private SquareValue coinTTT;

    public Player(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setCoinTTT(SquareValue coinTTT){
        this.coinTTT = coinTTT;
    }

    public SquareValue getCoinTTT(){
        return this.coinTTT;
    }

    public void setMyStatistics(StatisticsPlayer myStatistics){
        this.myStatistics = myStatistics;
    }

    public StatisticsPlayer getMyStatistics(){
        return this.myStatistics;
    }

    public void saveGameResult(TypeGame type, StatisticValue value){
        this.getMyStatistics().getListStatistics().add(new Statistic(value, type));
    }

    public void showStatistics(){
        for (Statistic statistic : getMyStatistics().getListStatistics()) {
            Terminal.showMessage("\tTipo de juego: "+statistic.getTypeGame());
            Terminal.showMessage("\tEstado del juego: "+statistic.getValue());
            Terminal.decorate();
        }
    }


}
