package gr.aueb.cf.miniProjects;


import java.util.Scanner;

/**
 * Gets from std-input a booking or cancel request for a theater seat,
 * evaluates, handles it and responds to user.
 */
public class TheaterApp {

    static boolean[][] seats = new boolean[30][12];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String response;
        char column;
        int row;

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = false;
            }
        }

        System.out.println("Please press B,q if you want to book a seat or C,c if you want to cancel");
        response = getChoice();


        if (response.matches("[Bb]")) {
            System.out.println("Please insert seat");
            response= in.nextLine().trim();
            column = response.charAt(0);
            row = Integer.parseInt(response.substring(1));
            book(column, row - 1);
        } else if (response.matches("[Cc]")){
            System.out.println("Please insert seat");
            response= in.nextLine().trim();
            column = response.charAt(0);
            row = Integer.parseInt(response.substring(1));
            cancel(column, row - 1);
        }
    }

    /**
     *  Gets users choice.
     * @return      Users choice.
     */
    public static String getChoice() {
        return in.nextLine().trim();
    }

    /**
     *  Books a seat.
     * @param column    Theater row.
     * @param row       Seat number
     */
    public static void book(char column, int row){
        if (!seats[row][column-'A']){
            seats[row][column-'A'] = true;
        }
    }


    /**
     *  Cancels a seat booking.
     * @param column    Theater row.
     * @param row       Seat number.
     */
    public static void cancel(char column, int row){
        if (seats[row][column-'A']){
            seats[row][column-'A'] = false;
        }
    }

}
