package MainMenu;


import games.Game;
import games.IPlayerGeneral;
import games.hangman.Hangman;
import games.tictactoe.TicTacToe;
import model.player.Bot;
import utils.Terminal;
import java.util.ArrayList;

public class ProgramMenu {
    
    private ArrayList<IPlayerGeneral> playerList = new ArrayList<>();

    public void initializeBots(){
        playerList.add(new Bot("Bot1"));
        playerList.add(new Bot("Bot2"));
    }

    public void menu() {
        int option;
        initializeBots();
        do {
            Terminal.clearScreen();
            Terminal.decorate();
            Terminal.showMessage("Seleccione una opcion");
            Terminal.showMessage("1. Tic tac toe");
            Terminal.showMessage("2. Hangman");
            Terminal.showMessage("3. Crud");
            Terminal.showMessage("4. Estadisticas");
            Terminal.showMessage("5. Salir");
            Terminal.decorate();
            option = Terminal.askNumber("Introduzca un numero");
            switch (option) {

                case 1 -> new TicTacToe(playerList, 2).go();
                case 2 -> new Hangman(playerList, 2).go();
                case 3 -> new controller.ControllerPlayer(playerList).crudMenu();
                case 4 -> showGeneralStatistics();
                default -> Terminal.showMessage("Gracias por su atencion");
            }
        } while (option != 5);
    }

    public void showGeneralStatistics(){
        for (IPlayerGeneral player : playerList) {
            Terminal.decorate();
            Terminal.showMessage("JUGADOR: "+player.getName());
            Terminal.showMessage("");
            player.showStatistics();
        }
        Terminal.pressEnter();
    }
}
