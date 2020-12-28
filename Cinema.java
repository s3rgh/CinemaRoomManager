package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        drawCinema(rows, seats);
        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();
        printPrice(rowNumber, rows, seats);
        drawChosenSeat(rowNumber, seatNumber, rows, seats);
    }

    private static void printPrice(int rowNumber, int rows, int seats) {
        int allSeats = rows * seats;
        int price = 0;
        if (allSeats <= 60) {
            price = 10;
        } else {
            if (rowNumber <= rows / 2) {
                price = 10;
            }
            if (rowNumber > rows / 2) {
                price = 8;
            }
        }
        System.out.println();
        System.out.println("Ticket price : $" + price);
        System.out.println();
    }

    private static void drawChosenSeat(int rowNumber, int seatNumber, int rows, int seats) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i <= rows; i++) {
            System.out.print(i + " ");
            for (int j = 1; j <= seats; j++) {
                if (rowNumber == i && seatNumber == j) {
                    System.out.print("B ");
                } else {
                    System.out.print("S ");
                }
            }
            System.out.println();
        }
    }

    private static void drawCinema(int rows, int seats) {
        System.out.println();
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i <= rows; i++) {
            System.out.print(i + " ");
            for (int j = 1; j <= seats; j++) {
                System.out.print("S ");
            }
            System.out.println();
        }
        System.out.println();
    }
}