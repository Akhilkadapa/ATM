package org.example;
import account.Account;
import authenticator.AuthenticationManager;
import exception.InsufficientFundsException;



    public class Main {
        public static void main(String[] args) {
            Account account = new Account(1000.0); // Initial balance $1000
            AuthenticatorManager authenticator = new AuthenticatorManager("1234"); // Initial PIN: "1234"
            UserInput userInput = new UserInput();
            ATMOperations atmOperations = new ATMOperations(account, authenticator);
            UserInterface userInterface = new UserInterface(atmOperations, userInput);

            userInterface.start();
        }
    }
