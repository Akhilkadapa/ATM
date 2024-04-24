package java.UI;

import java.util.Scanner;

public class UserInput {
    private Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public String getUserCommand() {
        System.out.println("Enter your command: ");
        return scanner.nextLine();
    }

    public double getAmount() {
        System.out.println("Enter amount: ");
        return Double.parseDouble(scanner.nextLine());
    }

    public String getNewPin() {
        System.out.println("Enter new PIN: ");
        return scanner.nextLine();
    }
}
