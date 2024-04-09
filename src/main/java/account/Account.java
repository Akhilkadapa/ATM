package account;



    // Account.java
    public class Account {
        private double balance;

        public Account(double initialBalance) {
            this.balance = initialBalance;
        }

        public double getBalance() {
            return balance;
        }

        public void withdraw(double amount) {
            try {
                if (amount <= 0) {
                    throw new IllegalArgumentException("Invalid amount");
                }
                if (amount > balance) {
                    throw new InsufficientFundsException("Insufficient funds");
                }
                balance = balance- amount;
                System.out.println("Withdrawal successful. Remaining balance: " + balance);
            } catch (IllegalArgumentException | InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
