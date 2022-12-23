package gr.aueb.cf.miniProjects;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeApp {
    static Scanner in = new Scanner(System.in);


    public static void main(String[] args) {
        String response;
        int count = 1;
        int move = 0;
        char symbol1 = ' ';
        char symbol2 = ' ';
        char[][] grid = { {' ','|',' ','|',' '},
                          {'-','+','-','+','-'},
                          {' ','|',' ','|',' '},
                          {'-','+','-','+','-'},
                          {' ','|',' ','|',' '}};


        System.out.println("Player one Choose Symbol between: O and X");
        response =  getChoice().toUpperCase();
        symbol1 = response.charAt(0);
        if (symbol1 == 'X'){
            symbol2 = 'O';
        } else {
            symbol2 = 'X';
        }


        do {
            if ((count % 2) == 1){
                System.out.println("please insert your next move");
                move = nextMove();
                updateArray(grid,move, symbol1);
                printArray(grid);
                if (hasWon(grid, symbol1)){
                    System.out.println("Player 1 Won!");
                    System.out.println("Congratulations!");
                }

            } else if ((count % 2) == 0) {
                System.out.println("please insert your next move 1-9");
                move = nextMove();
                updateArray(grid,move, symbol2);
                printArray(grid);
                if (hasWon(grid, symbol2)) {
                    System.out.println("Player 2 Won!");
                    System.out.println("Congratulations!");
                }
            }
            count++;
        } while(count < 10 && !hasWon(grid, symbol1));
        System.out.println("Thank you for playing!");
        }


        public static String getChoice() {
        return in.nextLine().trim();
        }
        public static int nextMove() throws InputMismatchException{
            int newMove = 0;
            try {
                newMove = in .nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                throw e;
            }
            return newMove;
        }


        public static void updateArray(char[][] arr, int move, char symbol) throws IllegalArgumentException{
            try{
                switch (move){
                    case 1:
                        arr[0][0] = symbol;
                        break;
                    case 2:
                        arr[0][2] = symbol;
                        break;
                    case 3:
                        arr[0][4] = symbol;
                        break;
                    case 4:
                        arr[2][0] = symbol;
                        break;
                    case 5:
                        arr[2][2] = symbol;
                        break;
                    case 6:
                        arr[2][4] = symbol;
                        break;
                    case 7:
                        arr[4][0] = symbol;
                        break;
                    case 8:
                        arr[4][2] = symbol;
                        break;
                    case 9:
                        arr[4][4] = symbol;
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
                throw ex;
            }
        }

        public static boolean hasWon(char[][] arr, char symbol){
            boolean won = false;
            //Vertical check

            for (int i = 0; i < arr.length; i+=2) {
                if (arr[i][0] == symbol && arr[i][2] == symbol && arr[i][4]== symbol) {
                    won = true;
                }
            }

            //Horizontal check
            for (int j = 0; j < arr[0].length; j+=2) {
                if (arr[0][j] == symbol && arr[2][j] == symbol && arr[4][j] == symbol) {
                    won = true;
                }
            }

            //Diagonal check.
            if (arr[0][0] == symbol && arr[2][2] == symbol && arr[4][4]== symbol){
                won = true;
            } else if (arr[0][4] == symbol && arr[2][2] == symbol && arr[4][0] == symbol) {
                won = true;
            }
            return won;
        }

        public static void printArray(char[][] grid) {
            for (char[] row : grid){
                for (char col : row){
                 System.out.print(col);
                 }
                System.out.println();
            }
    }
    }

