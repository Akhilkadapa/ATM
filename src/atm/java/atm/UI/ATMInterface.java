package atm.UI;

import atm.core.ATMOperations;
import atm.exception.InsufficientFundsException;

public class ATMInterface {
    private final ATMOperations atmOperations;
    private final UserInput userInput;

    public ATMInterface(ATMOperations atmOperations, UserInput userInput) {
        this.atmOperations = atmOperations;
        this.userInput = userInput;
    }

    public void start() {
        boolean isAuthenticated = false;
        while (!isAuthenticated) {
            String pin = userInput.getUserCommand();
            try {
                isAuthenticated = atmOperations.authenticate(pin);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
            if (!isAuthenticated) {
                System.out.println("Invalid PIN. Please try again.");
            }
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("1. Balance Enquiry");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Change PIN");
            System.out.println("4. Exit");

            String choice = userInput.getUserCommand();
            switch (choice) {
                case "1":
                    atmOperations.displayBalance();
                    break;
                case "2":
                    try {
                        double amount = userInput.getAmount();
                        atmOperations.withdrawMoney(amount);
                    } catch (IllegalArgumentException | InsufficientFundsException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "3":
                    String newPin = userInput.getNewPin();
                    atmOperations.changePin(newPin);
                    break;
                case "4":
                    exit = true;
                    System.out.println("Exiting ATM. Thank you for using our service!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}
