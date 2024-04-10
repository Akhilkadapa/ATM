
// UserInterface.java
public class UserInterface {

        private ATMOperations atmOperations;
        private UserInput userInput;

        public UserInterface(ATMOperations atmOperations, UserInput userInput) {
            this.atmOperations = atmOperations;
            this.userInput = userInput;
        }

        public void start() {
            System.out.println("Welcome to the ATM");
            String pin = userInput.getInput("Please enter your PIN: ");
            if (!atmOperations.authenticate(pin)) {
                System.out.println("Invalid PIN. Exiting...");
                return;
            }

            showMenu();
        }

        private void showMenu() {
            while (true) {
                System.out.println("\n1. Balance Enquiry");
                System.out.println("2. Withdraw Money");
                System.out.println("3. Change PIN");
                System.out.println("4. Exit");
                int choice = userInput.getIntInput("Enter your choice: ");

                switch (choice) {
                    case 1:
                        atmOperations.displayBalance();
                        break;
                    case 2:
                        withdrawMoney();
                        break;
                    case 3:
                        changePin();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        private void withdrawMoney() {
            double amount = userInput.getAmountInput("Enter amount to withdraw: $");
            atmOperations.withdrawMoney(amount);
        }

        private void changePin() {
            String newPin = userInput.getInput("Enter new PIN: ");
            atmOperations.changePin(newPin);
        }
    }

