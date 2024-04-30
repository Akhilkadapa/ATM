package ui;

import java.util.Scanner;

public class UserInput {
    private Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public String getUserCommand() {
        System.out.println("Enter your PIN: ");
        return scanner.nextLine();
    }

    public double getAmount() {
        System.out.println("Enter amount: ");
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public String getNewPin() {
        System.out.println("Enter new PIN: ");
        return scanner.nextLine();
    }
}
