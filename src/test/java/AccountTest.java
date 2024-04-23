

// AccountTest.java
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import account.Account;
import exception.InsufficientFundsException;
import org.junit.Test;

public class AccountTest {
    @Test
    public void testWithdraw() throws InsufficientFundsException {
        Account account = new Account(1000);
        account.withdraw(500);
        assertEquals(500, account.getBalance(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawNegativeAmount() {
        Account account = new Account(1000);
        try {
            account.withdraw(-500);
        } catch (InsufficientFundsException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(expected = InsufficientFundsException.class)
    public void testWithdrawInsufficientFunds() {
        Account account = new Account(1000);
        try {
            account.withdraw(5000);
        } catch (InsufficientFundsException e) {
            // Insufficient funds exception occurred, test passed
            return;
        }
        // If no exception occurred, the test failed
        fail("Expected InsufficientFundsException was not thrown");
    }
}
