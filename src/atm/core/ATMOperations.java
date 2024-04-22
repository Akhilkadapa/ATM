package core;

import account.Account;
import exception.InsufficientFundsException;
import authenticator.AuthenticatorManager;



public class ATMOperations {
    private final Account account;
    private final AuthenticatorManager authenticator;

    public ATMOperations(Account account, AuthenticatorManager authenticator) {
        this.account = account;
        this.authenticator = authenticator;
    }

    public boolean authenticate(String pin) {
        return authenticator.validatePin(pin);
    }

    public void displayBalance() {
        System.out.println("Current Balance: $" + account.getBalance());
    }

    public void withdrawMoney(double amount) {
        try {
            account.withdraw(amount);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void changePin(String newPin) {
        try {
            authenticator.changePin(newPin);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
