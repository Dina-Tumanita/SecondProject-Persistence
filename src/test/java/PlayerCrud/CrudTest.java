package PlayerCrud;
import controller.ControllerPlayer;
import games.IPlayerGeneral;
import model.player.Human;
import model.player.Bot;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class CrudTest {

    private ArrayList<IPlayerGeneral> playerList2;
    private ControllerPlayer controlPlayer;

    @Before
    public void initialValues(){
        playerList2 = new ArrayList<>();
        controlPlayer = new ControllerPlayer(playerList2);
    }

    @Test
    public void testEmptyPlayerTrue(){
        boolean emptyList = playerList2.isEmpty();
        assertEquals(true, emptyList);
    }

    @Test
    public void testInvalidCapacity(){

        playerList2 = new ArrayList<>(-1);
    }

    @Test
    public void testListInit(){
        assertTrue(playerList2.isEmpty());
        assertTrue(playerList2.size() == 0);
    }

    @Test
    public void testShowItems(){
        playerList2.add(0, new Human("Human1"));
        playerList2.add(1, new Human("Human1"));
        playerList2.add(2, new Bot("boot1"));
        playerList2.add(3, new Bot("boot3"));
        controlPlayer.ShowPlayers();
    }

}