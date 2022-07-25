package games.hangman;

import java.util.ArrayList;

import games.Game;
import games.IPlayerGeneral;
import statistics.StatisticValue;
import statistics.TypeGame;
import utils.Terminal;

public class Hangman extends Game{ 
    
    private WordHG myWord;
    private IGuesserable playerGuesser; 
    private IGiverable playerGiver; 
    public IPlayerGeneral player1; 
    public IPlayerGeneral player2; 
    private BoardHangMan board;

    private int remainingAttempts; 
    private int guessingAttempts; 
    private boolean hintGiven;
    private int firstPlay;

 
    public Hangman(ArrayList<IPlayerGeneral> generalList, int totalPlayers) {
        super(generalList, totalPlayers);
        this.selectPlayer(this.listProviders);
    }

    public Hangman(){}

    @Override
    public void go() {
        firstPlay  = (int) (Math.random()*(2)) + 1; 
        for (int i = 0; i < 2; i++){
            play(i);
        }
    }

    private void play(int round){
        startUp();
        Terminal.showMessage("Round #" + (round+1));
        do {
            round();
        } while (!board.winCondition);
        checkWinner(); 
        Terminal.pressEnter();

    }

    @Override
    public void turn() {
        if (guessingAttempts == 1) firstTurn();
        else  otherTurns();          
        guessingAttempts++;  
        
    }


    public void startUp(){
        Terminal.clearScreen();
        Terminal.decorate();
        Terminal.showMessage("*******WELCOME TO HANGMAN*******");
        Terminal.decorate();
        hintGiven = false;
        guessingAttempts = 1;
        remainingAttempts = 8; 
        board = new BoardHangMan();
        board.cleanBoard();
        setPlayers();     
        choose1stPlayer();
    }  

    public void setPlayers(){ 
        Terminal.showMessage("Randomly choosing First Player"); 
        player1 = this.players.get(0); 
        player2 = this.players.get(1);  
    }

    private void choose1stPlayer(){
        if (firstPlay == 1){  
            playerGiver = player2; 
            playerGuesser = player1; 
            firstPlay++;     
        } else { 
            playerGiver = player1; 
            playerGuesser = player2; 
            firstPlay = 1;               
        }         
    }


    private void round(){
        try {
            turn();
            board.printHangMan();
            myWord.printMissingLetters();
        } catch (Exception e){
            if (hintGiven){
                Terminal.showMessage("Please enter a letter"); 
                } else {
                    hintGiven = true; 
                    myWord.giveHint();
                }
        }

    }
    
    private void offerHint(){
        if (hintGiven){
            Terminal.showMessage("No more hints"); 
        } else 
        Terminal.showMessage("Leave blank for a hint");

    }

    private void checkWinner(){
        if (remainingAttempts == 0){
            Terminal.showMessage(playerGiver.getName() + " is Winner!!!!"); 
            playerGiver.saveGameResult(TypeGame.HANGMAN, StatisticValue.WIN);
            playerGuesser.saveGameResult(TypeGame.HANGMAN, StatisticValue.LOSE);            
            Terminal.showMessage(myWord.getOriginalWord() + " was the secret word."); 
        } else {
            Terminal.showMessage(playerGuesser.getName() + " is Winner!!!!"); 
            playerGiver.saveGameResult(TypeGame.HANGMAN, StatisticValue.LOSE);
            playerGuesser.saveGameResult(TypeGame.HANGMAN, StatisticValue.WIN);
        }
    }

    private void firstTurn(){
        String secretWord = "";
        System.out.print("First Player is: ");   
        Terminal.showMessage(playerGiver.getName());  
        Terminal.showMessage("");   
        secretWord = playerGiver.selectWord();            
        myWord = new WordHG(secretWord);
        myWord.createGuessWord();        
    }

    private void otherTurns(){
        Terminal.showMessage("Playing turn #" + guessingAttempts); 
        Terminal.showMessage("Guessing attempts left " + (remainingAttempts)); 
        String currentGuess = "";
        offerHint();
        currentGuess = playerGuesser.tryLetter();  
        myWord.setGuessingLetter(currentGuess);
        //
        if (!myWord.checkLetter()){
            remainingAttempts--;
            board.setHangmanParts(remainingAttempts);  
            board.editHangedMan();       
        } else board.setWinCondition(myWord.checkWin()); 
        
    }
    
}
