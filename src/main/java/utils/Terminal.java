package utils;

import java.util.Scanner;

public class Terminal {
        
    public static Integer askNumber(String message){
        try {
            Scanner scanner = new Scanner(System.in);
            showMessage(message);
            return scanner.nextInt();
        } catch(NumberFormatException e){
            showMessage("Error with received input");
        }
        return null;
    }

    public static String askString(String message){
        Scanner scanner = new Scanner(System.in);
        showMessage(message);
        return scanner.nextLine();
    }

    public static void showMessage(String message){
        System.out.println(message);
    }   

    public static void decorate(){
        System.out.println("***********************************************");
    }

    public static void clearScreen(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            /*No hace nada*/
        }
    }

    public static void pressEnter(){
        showMessage("Press ENTER to continue");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}
