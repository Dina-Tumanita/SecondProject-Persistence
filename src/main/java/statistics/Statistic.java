package statistics;

import utils.Terminal;

public class Statistic {

    private StatisticValue value;
    private TypeGame typeGame;

    public Statistic(StatisticValue value, TypeGame typeGame){
        this.value = value;
        this.typeGame = typeGame;
    }

    public StatisticValue getValue(){
        return this.value;
    }

    public void setValue(StatisticValue value){
        this.value = value;
    }

    public TypeGame getTypeGame(){
        return this.typeGame;
    }

    public void setTypeGame(TypeGame typeGame){
        this.typeGame = typeGame;
    }

}
