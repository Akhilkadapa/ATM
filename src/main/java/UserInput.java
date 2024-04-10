
// UserInput.java


public class UserInput {
    public String getInput(String prompt) {
        System.out.print(prompt);
        return System.console().readLine();
    }

    public double getAmountInput(String prompt) {
        while (true) {
            try {
                String input = getInput(prompt);
                double amount = Double.parseDouble(input);
                if (amount <= 0) {
                    throw new IllegalArgumentException("Invalid amount");
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("Error: Input must be a valid number");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

}

