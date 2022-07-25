package games.hangman;

import utils.Terminal;

public class WordHG {
    public String originalWord;     //secret word

    public String hiddenWord;       //word that is being spelled out
    public String guessingLetter;   //Letter that is guessed
    public String lettersGuessed;   //letters that have been guessed

    public WordHG(String originalWord) {
        this.originalWord = originalWord;
        this.lettersGuessed = " ";
        this.guessingLetter = " ";
        this.hiddenWord = " ";
    }
    
    public void setGuessingLetter(String guessingLetter) {
        this.guessingLetter = guessingLetter;
    }
    
    public String getOriginalWord() {
        return originalWord;
    }

    private int getExistingPosition(){        
        int letterPosition = this.originalWord.indexOf(this.guessingLetter.toLowerCase()); 
        return letterPosition;
    }

    public void createGuessWord(){
        this.hiddenWord = "";
        for (int i = 0; i < this.originalWord.length(); i++){
            this.hiddenWord += " ";
        }
    }


    public void printGuessedLetters(){
        System.out.print("Letters guessed: ");
        char[] letters = this.lettersGuessed.toCharArray();
        placeGuessedLetters();

        for (int i = 0; i < letters.length; i++){
            System.out.print(String.valueOf(letters[i]) + " ");
        }
        Terminal.showMessage(""); 

    }

    private void placeGuessedLetters(){
        if (!alreadyGuessed()){
            this.lettersGuessed += this.guessingLetter;
        }

    }

    private boolean alreadyGuessed(){        
        boolean guessedAlready = (this.lettersGuessed.indexOf(this.guessingLetter) == -1) ? false : true;
        return guessedAlready;

    }

    private void placeLetters(){
        char[] secretWordarray = this.originalWord.toCharArray();
        int wordLen = secretWordarray.length;
        char[] hiddenWordarray = this.hiddenWord.toCharArray();
        char letter = this.guessingLetter.toCharArray()[0];

        for (int i = 0; i < wordLen; i++){
            if (secretWordarray[i] == letter) {
                hiddenWordarray[i] = letter;

            }
        }
        this.hiddenWord = String.valueOf(hiddenWordarray);        
    }

    public boolean checkWin(){
        char[] secretWordarray = this.originalWord.toCharArray();
        char[] hiddenWordarray = this.hiddenWord.toCharArray();
        int wordLen = secretWordarray.length;
        boolean wordIsGuessed = true;
        try {
        for (int i = 0; i < wordLen; i++){
            if (secretWordarray[i] != hiddenWordarray[i]) {
                wordIsGuessed = false;
            }
        }} catch (Exception e) {
            
        }
        return wordIsGuessed;
    }

    public void printMissingLetters(){
        char[] secretWordarray = this.originalWord.toCharArray();
        Terminal.showMessage(this.hiddenWord);  

        for (int i = 0; i < secretWordarray.length; i++){
            System.out.print("-");                             
        }
        Terminal.showMessage(""); 
    }

    public boolean checkLetter(){
        int letterPosition = getExistingPosition();

        if (alreadyGuessed() && this.guessingLetter != ""){
            Terminal.showMessage("Already guessed this letter"); 
            printGuessedLetters(); 
            return true;
        }
        
        if (letterPosition == -1 ){
            Terminal.showMessage(this.guessingLetter + " is not in word");
            printGuessedLetters(); 
            return false;
        }
        else {
            if (this.guessingLetter != ""){
                Terminal.showMessage(this.guessingLetter + " is in word!!"); 
            }            
            placeLetters();
            printGuessedLetters(); 
            return true;
        }

    }
    
    public void giveHint(){
        char[] secretWordarray = this.originalWord.toCharArray();
        int wordLen = secretWordarray.length;
        char[] hiddenWordarray = this.hiddenWord.toCharArray();

        for (int i = 0; i < wordLen; i++){
            if (hiddenWordarray[i] == ' ') {
                hiddenWordarray[i] = secretWordarray[i];
                break;
            }
        }
        this.hiddenWord = String.valueOf(hiddenWordarray);
        Terminal.showMessage("**HINT GIVEN**"); 
        printMissingLetters();
    }


}
