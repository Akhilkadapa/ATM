package ui;

import authenticator.AuthenticatorManager;
import core.ATMOperations;

public class ATMInterface {
    private final ATMOperations atmOperations;
    private final UserInput userInput;

    public ATMInterface(ATMOperations atmOperations, UserInput userInput) {
        this.atmOperations = atmOperations;
        this.userInput = userInput;
    }

    public void start() {
        AuthenticatorManager authenticator = atmOperations.getAuthenticator();
        int maxAttempts = authenticator.getMaxFailedAttempts();

        System.out.println("Maximum failed attempts allowed: " + maxAttempts);

        int failedAttempts = 0;

        do {
            String pin = userInput.getUserCommand();
            if (atmOperations.authenticate(pin)) {
                break;
            } else {
                failedAttempts++;
                if (failedAttempts >= maxAttempts) {
                    System.out.println("Account locked. Too many failed login attempts. Exiting ATM.");
                    return;
                }
            }
        } while (true);


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
                    double amount = userInput.getAmount();
                    atmOperations.withdrawMoney(amount);
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
