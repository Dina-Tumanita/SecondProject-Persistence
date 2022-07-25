package controller;

import games.IPlayerGeneral;
import model.player.*;
import utils.Terminal;
import java.util.ArrayList;
import java.util.Iterator;

public class ControllerPlayer {
    static String name, name2;
    private ArrayList<IPlayerGeneral> playerList;

    public ControllerPlayer(ArrayList<IPlayerGeneral> playerList) {
        this.playerList = playerList;
    }

    public void crudMenu() {
        int option;

        do {
            Terminal.showMessage("--------------------------");
            Terminal.showMessage("Bienvenido al Menu del Administrador");
            Terminal.showMessage("1. Crear Jugador");
            Terminal.showMessage("2. Leer Jugadores");
            Terminal.showMessage("3. Actualizar Jugadores");
            Terminal.showMessage("4. Borrar jugadores");
            Terminal.showMessage("5. Obtener jugador");
            Terminal.showMessage("6. Mostrar a todos los jugadores");
            Terminal.showMessage("7. Regresar al menu principal");
            Terminal.showMessage("--------------------------");
            option = Terminal.askNumber("Introduzca un numero");
            ;
            switch (option) {
                case 1 -> createPlayer();
                case 2 -> readPlayer();
                case 3 -> updatePlayer();
                case 4 -> removePlayer();
                case 5 -> getOne();
                case 6 -> ShowPlayers();
                case 7 -> new MainMenu.ProgramMenu();
                default -> Terminal.showMessage("Vuelva a intentar");
            }
        } while (option != 7);
    }

    public void createPlayer() {
        Terminal.showMessage("Ingrese un numero");
        Terminal.showMessage("1. Humano\n2. Bot");
        int option = Terminal.askNumber("Introduzca un numero");
        if (option == 1) {
            name = Terminal.askString("Introduzca un nombre para el jugador Humano");
            Player human = new Human(name);
            playerList.add(human);
        } else if (option == 2) {
            name = Terminal.askString("Introduzca un nombre para el jugador Bot");
            Player boot = new Bot(name);
            playerList.add(boot);
            //Terminal.showMessage("index: " + playerList.indexOf(boot));
        }
    }

    public void readPlayer() {
        boolean found = false;
        Terminal.showMessage("--------------------------");
        name = Terminal.askString("Ingresa el Nombre del jugador que buscas");
        Iterator<IPlayerGeneral> i = playerList.iterator();
        while (i.hasNext()) {
            IPlayerGeneral players = i.next();
            if (players.getName().equals(name)) {
                Terminal.showMessage("Jugador: " + name + " fue encontrado");
                found = true;
            }
        }
        if (!found) {
            Terminal.showMessage("Jugador no encontrado");
        }
    }

    public void updatePlayer() {
        Terminal.showMessage("--------------------------");
        name = Terminal.askString("Ingresa el Nombre del jugador que quieres modificar");
        name2 = Terminal.askString("Ingresa el nuevo nombre");
        Iterator<IPlayerGeneral> i = playerList.iterator();
        while (i.hasNext()) {
            IPlayerGeneral players = i.next();
            if (players.getName().equals(name)) {
                players.setName(name2);
            }
        }
    }

    public void removePlayer() {
        boolean found = false;
        Terminal.showMessage("--------------------------");
        name = Terminal.askString("Ingresa el nombre del jugador que quieres modificar");
        Iterator<IPlayerGeneral> i = playerList.iterator();
        while (i.hasNext()) {
            IPlayerGeneral player = i.next();
            if (player.getName().equals(name)) {
                i.remove();
                found = true;
            }
        }
        if (!found) {
            Terminal.showMessage("Jugador no encontrado");
        } else {
            Terminal.showMessage("Jugador fue borrado satisfactoriasmente");
        }
    }

    public IPlayerGeneral getOne() {
        ShowPlayers();
        int playerPosition = Terminal.askNumber("Ingrese número del 1-10 para seleccionar un jugador");
        if (playerPosition - 1 < playerList.size())
            return this.playerList.get(playerPosition - 1);
        Terminal.showMessage("La posición no existe");
        return null;
    }

    public void ShowPlayers() {
        Terminal.showMessage("--------------------------");
        Terminal.showMessage("Lista de jugadores Creados");
        int i = 1;
        for (IPlayerGeneral player : playerList) {

            Terminal.showMessage(i + ". " + player.getName());
            i++;
            //Terminal.showMessage("index: " + playerList.indexOf(player));
        }
    }
}