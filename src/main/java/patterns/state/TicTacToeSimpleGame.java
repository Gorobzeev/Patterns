package patterns.state;

import java.util.Scanner;

public class TicTacToeSimpleGame {
    static String currentPlayer = null;
    static String player1 = "x";
    static String player2 = "o";
    static String[][] desk = new String[3][3];
    static final String EMPTY = " ";
    private static boolean gameOver = false;


    public static void main(String[] args) {

        System.out.println("Start game !!!");
        fillDeskEmptyString();
        Scanner scanner = new Scanner(System.in);
        currentPlayer = player1;

        while (!gameOver && !isBoardFull()) {

            System.out.println("Player " + currentPlayer + " step: ");

            System.out.println("Chose line number: 1-3");
            String horizontal = scanner.nextLine();

            System.out.println("Chose vertical number: 1-3");
            String vertical = scanner.nextLine();

            if (writeStepToDesc(horizontal, vertical, currentPlayer)) {
                definedWins();
                currentPlayer = definePlayerStep(currentPlayer);
            }
        }

        System.out.println("Game over");
    }

    private static boolean writeStepToDesc(String horizontal, String vertical, String currentPlayer) {

        Integer x;
        Integer y;
        try {
            x = Integer.valueOf(horizontal);
            y = Integer.valueOf(vertical);
        } catch (NumberFormatException e) {
            System.out.println("Input step error format - " + e.getLocalizedMessage());
            return false;
        }

        if (desk[x - 1][y - 1].equals(EMPTY)) {
            desk[x - 1][y - 1] = currentPlayer;
        } else {
            System.out.println("Not correct step");
            return false;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + desk[i][j] + "|");
            }
            System.out.println("\n");
        }
        return true;
    }


    private static String definePlayerStep(String currentPlayer) {
        if (currentPlayer.equals(player1)) {
            return player2;
        }
        return player1;
    }

    private static void definedWins() {

        for (int i = 0; i < 3; i++) {
            if (desk[i][0].equals(currentPlayer) && desk[i][1].equals(currentPlayer) && desk[i][2].equals(currentPlayer)) {
                System.out.println("Player " + currentPlayer + " WIN !!!");
                gameOver = true;
                return;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (desk[0][i].equals(currentPlayer) && desk[1][i].equals(currentPlayer) && desk[2][i].equals(currentPlayer)) {
                System.out.println("Player " + currentPlayer + " WIN !!!");
                gameOver = true;
                return;
            }
        }
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (desk[i][j].equals(EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }


    private static void fillDeskEmptyString() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                desk[i][j] = EMPTY;
            }
        }
    }


}
