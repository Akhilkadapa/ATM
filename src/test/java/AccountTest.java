

// AccountTest.java
import static org.junit.Assert.assertEquals;

import atm.account.Account;
import atm.exception.InsufficientFundsException;
import org.junit.Test;

public class AccountTest {
    @Test
    public void testWithdraw() {
        Account account = new Account(1000);
        account.withdraw(500);
        assertEquals(500, account.getBalance(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawNegativeAmount() {
        Account account = new Account(1000);
        account.withdraw(-500);
    }

    @Test(expected = InsufficientFundsException.class)
    public void testWithdrawInsufficientFunds() {
        Account account = new Account(100);
        account.withdraw(500);
    }
}
