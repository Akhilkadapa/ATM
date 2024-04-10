
// ATMOperations.java
import account.Account;
import authenticator.AuthenticationManager;

public class ATMOperations {
    private Account account;
    private AuthenticatorManager authenticator;

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
        authenticator.changePin(newPin);
    }
}
