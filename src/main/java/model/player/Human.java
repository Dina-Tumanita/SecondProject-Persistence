package model.player;

import model.player.Player;
import statistics.Statistic;
import statistics.StatisticValue;
import statistics.TypeGame;
import utils.Terminal;

public class Human extends Player {
    
    public Human(String name){
        super(name);
    }

    public int returnPosition(){
        int number = Terminal.askNumber("Type a number");
        if(number < 1 || number > 3){
            Terminal.showMessage("Invalid range position");
            return returnPosition();
        } else {
            return number - 1;
        }
    }

    public String selectWord() {
        String msg = (this.getName() + ", enter secretword: ");  
        String secretWord = Terminal.askString(msg);
        Terminal.pressEnter();
        Terminal.clearScreen();
        return secretWord;
    }

    public String tryLetter() {          
        String msg = (this.getName() + ", enter letter guess: ");  
        String guess = Terminal.askString(msg);
        return guess;
    }



}
