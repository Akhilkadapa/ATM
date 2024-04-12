

import atm.UI.ATMInterface;
import atm.UI.UserInput;
import atm.account.Account;
import atm.core.ATMOperations;
import authenticator.AuthenticatorManager;



public class Main {
    public static void main(String[] args) {
        Account account = new Account(1000.0); // Initial balance $1000
        AuthenticatorManager authenticator = new AuthenticatorManager("1234"); // Initial PIN: "1234"
        UserInput userInput = new UserInput();
        ATMOperations atmOperations = new ATMOperations(account, authenticator);
        ATMInterface atmInterface = new ATMInterface(ATMOperations, userInput);

        atmInterface.start();
    }
}
