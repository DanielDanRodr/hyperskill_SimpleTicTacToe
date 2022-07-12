package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // game state
        
        boolean xWins = false;
        boolean oWins = false;
        boolean draw = false;
        boolean gameEnds = false;

        // printing empty grid
        
        System.out.println("---------");
        System.out.println("|       |");
        System.out.println("|       |");
        System.out.println("|       |");
        System.out.println("---------");

        // initial matrix
        
        char[][] matrix = new char[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = ' ';
            }
        }

        // iterating by coordinates
        
        int coordinate1 = 0;
        int coordinate2 = 0;
        boolean allChecks = false;
        boolean lastPlayerX = false;
        int counterX = 0;
        int counterO = 0;

        while (!gameEnds) {
            allChecks = false;
            do {
                System.out.println("Enter the coordinates: ");
                if (scanner.hasNextInt()) {
                    coordinate1 = scanner.nextInt();
                } else {
                    System.out.println("You should enter numbers!");
                    continue;
                }
                if (scanner.hasNextInt()) {
                    coordinate2 = scanner.nextInt();
                } else {
                    System.out.println("You should enter numbers!");
                    continue;
                }
                if (coordinate1 < 1 || coordinate1 > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (coordinate2 < 1 || coordinate2 > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (matrix[coordinate1 - 1][coordinate2 - 1] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
                allChecks = true;
                if (lastPlayerX == false) {
                    matrix[coordinate1 - 1][coordinate2 - 1] = 'X';
                    lastPlayerX = true;
                    counterX++;
                } else {
                    matrix[coordinate1 - 1][coordinate2 - 1] = 'O';
                    counterO++;
                    lastPlayerX = false;
                }
            } while (!allChecks);

            // printing updated grid
            System.out.println("---------");
            for (int i = 0; i < 3; i++) {
                System.out.print("|" + " ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(matrix[i][j] + " ");
                    if (j == 2) {
                        System.out.println("|");
                    }
                }
            }
            System.out.println("---------");

            // checking game state

            if (matrix[0][0] == matrix[0][1] && matrix[0][1] == matrix[0][2]) {
                if (matrix[0][0] == 'X') {
                    xWins = true;
                } else if (matrix[0][0] == 'O') {
                    oWins = true;
                }
            }
            if (matrix[1][0] == matrix[1][1] && matrix[1][1] == matrix[1][2]) {
                if (matrix[1][0] == 'X') {
                    xWins = true;
                } else if (matrix[1][0] == 'O') {
                    oWins = true;
                }
            }
            if (matrix[2][0] == matrix[2][1] && matrix[2][1] == matrix[2][2]) {
                if (matrix[2][0] == 'X') {
                    xWins = true;
                } else if (matrix[2][0] == 'O') {
                    oWins = true;
                }
            }

            if (matrix[0][0] == matrix[1][0] && matrix[1][0] == matrix[2][0]) {
                if (matrix[0][0] == 'X') {
                    xWins = true;
                } else if (matrix[0][0] == 'O') {
                    oWins = true;
                }
            }
            if (matrix[0][1] == matrix[1][1] && matrix[1][1] == matrix[2][1]) {
                if (matrix[0][1] == 'X') {
                    xWins = true;
                } else if (matrix[0][1] == 'O') {
                    oWins = true;
                }
            }
            if (matrix[0][2] == matrix[1][2] && matrix[1][2] == matrix[2][2]) {
                if (matrix[0][2] == 'X') {
                    xWins = true;
                } else if (matrix[0][2] == 'O') {
                    oWins = true;
                }
            }

            if (matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2]) {
                if (matrix[0][0] == 'X') {
                    xWins = true;
                } else if (matrix[0][0] == 'O') {
                    oWins = true;
                }
            }
            if (matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0]) {
                if (matrix[0][2] == 'X') {
                    xWins = true;
                } else if (matrix[0][2] == 'O') {
                    oWins = true;
                }
            }

            System.out.println(counterX);
            System.out.println(counterO);

            if ((counterX + counterO) >= 9) {
                draw = true;

            }

            if (xWins) {
                gameEnds = true;
            } else if (oWins) {
                gameEnds = true;
            } else if (draw) {
                gameEnds = true;
            }
        }
        
        // printing final grid

        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|" + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
                if (j == 2) {
                    System.out.println("|");
                }
            }
        }
        System.out.println("---------");
        
        
        // printing the result
        
        if (xWins) {
            System.out.println("X wins");
        } else if (oWins) {
            System.out.println("O wins");
        } else if (draw) {
            System.out.println("Draw");
        }


    }
}
