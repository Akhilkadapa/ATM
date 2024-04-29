import UI.ATMInterface;
import UI.UserInput;
import account.Account;
import authenticator.AuthenticatorManager;
import core.ATMOperations;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(1000.0); // Initial balance £1000
        AuthenticatorManager authenticator = new AuthenticatorManager("1234"); // Initial PIN: "1234"
        UserInput userInput = new UserInput();
        ATMOperations atmOperations = new ATMOperations(account, authenticator);
        ATMInterface atmInterface = new ATMInterface(atmOperations, userInput);
        atmInterface.start();
    }
}