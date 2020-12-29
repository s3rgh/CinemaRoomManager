package cinema;

import java.util.Scanner;

public class Cinema {

    String[][] places;

    public Cinema(String[][] places) {
        this.places = places;
    }

    private static Cinema createCinema(int rows, int seats) {
        String[][] places = new String[rows][seats];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                places[i][j] = "S";
            }
        }
        return new Cinema(places);
    }

    private void menu(Cinema cinema) {
        Scanner scanner = new Scanner(System.in);
        int choose;
        do {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("0. Exit");
            System.out.println();
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    drawCinema(cinema);
                    continue;
                case 2:
                    cinema = buyTicket(cinema);
                    break;
                case 0:
                    break;
            }
        } while (choose != 0);
    }

    private Cinema buyTicket(Cinema cinema) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();
        int allSeats = cinema.places.length * cinema.places[0].length;
        int price = 0;
        if (allSeats <= 60) {
            price = 10;
        } else {
            if (rowNumber <= cinema.places.length / 2) {
                price = 10;
            }
            if (rowNumber > cinema.places.length / 2) {
                price = 8;
            }
        }
        System.out.println();
        System.out.println("Ticket price : $" + price);
        System.out.println();

        cinema.places = drawChosenSeat(rowNumber, seatNumber, cinema);
        return this;
    }

    private static String[][] drawChosenSeat(int rowNumber, int seatNumber, Cinema cinema) {
        for (int i = 0; i < cinema.places.length; i++) {
            for (int j = 0; j < cinema.places[0].length; j++) {
                if (i == rowNumber - 1 && j == seatNumber - 1) {
                    cinema.places[i][j] = "B";
                }
            }
        }
        return cinema.places;
    }

    private static void drawCinema(Cinema cinema) {
        System.out.println();
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= cinema.places[0].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < cinema.places.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < cinema.places[0].length; j++) {
                System.out.print(cinema.places[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        System.out.println();
        Cinema cinema = createCinema(rows, seats);
        cinema.menu(cinema);
    }
}