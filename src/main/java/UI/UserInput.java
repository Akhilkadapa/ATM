package UI;

import java.util.Scanner;

public class UserInput {
    private static Scanner scanner;

    public UserInput() {
        scanner = new Scanner(System.in);
    }

    public static String getUserCommand() {
        System.out.println("Enter your PIN: ");
        return scanner.nextLine();
    }

    public static double getAmount() {
        System.out.println("Enter amount: ");
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static String getNewPin() {
        System.out.println("Enter new PIN: ");
        return scanner.nextLine();
    }
}
