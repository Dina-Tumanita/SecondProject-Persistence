package games.hangman;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class WordHGTest {
    private WordHG myWord;

    
    @Before 
    public void initializeValues(){
        myWord = new WordHG("Test");
        
    }

    @Test
    public void testCheckLetterisNotNull() {
        assertNotNull(myWord.checkLetter());
    }

    @Test
    public void testCheckWinisNotNull() {
        assertNotNull(myWord.checkWin());
    }

    @Test
    public void testGetOriginalWord() {
        assertNotNull(myWord.getOriginalWord());
    }

    @Test
    public void testGiveHint() {
        myWord.giveHint();
        assertNotNull(myWord.hiddenWord);
    }


    @Test
    public void testSetGuessingLetter() {
        myWord.setGuessingLetter("test");
        assertNotNull(myWord.guessingLetter);        
    }
}
