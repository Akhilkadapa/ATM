package account;
import exception.InsufficientFundsException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class AccountTest {
    private Account account;

    @Before
    public void setUp() {
        account = new Account(1000);
    }

    @Test
    public void testWithdraw() {
        try {
            account.withdraw(500);
            assertEquals(500, account.getBalance(), 0.001);
        } catch (InsufficientFundsException e) {
            fail("Unexpected InsufficientFundsException occurred");
        }
    }

    @Test
    public void testWithdrawNegativeAmount() {
        try {
            account.withdraw(-500);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            // Expected IllegalArgumentException, test passes
        } catch (InsufficientFundsException e) {
            fail("Unexpected InsufficientFundsException occurred");
        }
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        try {
            account.withdraw(5000);
            fail("Expected InsufficientFundsException was not thrown");
        } catch (InsufficientFundsException e) {
            // Expected InsufficientFundsException, test passes
        }
    }
}
