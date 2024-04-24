import account.Account;
import authenticator.AuthenticatorManager;
import core.ATMOperations;
import exception.InsufficientFundsException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ATMOperationsTest {
    private Account mockAccount;
    private AuthenticatorManager mockAuthenticator;
    private ATMOperations atmOperations;

    @Before
    public void setUp() {
        mockAccount = mock(Account.class);
        mockAuthenticator = mock(AuthenticatorManager.class);
        atmOperations = new ATMOperations(mockAccount, mockAuthenticator);
    }

    @Test
    public void testAuthenticate() {
        when(mockAuthenticator.validatePin("1234")).thenReturn(true);
        assertTrue(atmOperations.authenticate("1234"));
    }

    @Test
    public void testDisplayBalance() {
        when(mockAccount.getBalance()).thenReturn(100.0);
        atmOperations.displayBalance();
        // Verify that the balance is correctly printed
        verify(mockAccount).getBalance();
    }

    @Test
    public void testWithdrawMoney() throws InsufficientFundsException {
        // Stubbing the behavior of the account
        doNothing().when(mockAccount).withdraw(50.0);
        // Test the withdrawal method
        atmOperations.withdrawMoney(50.0);
        // Verify that the withdrawal was made
        verify(mockAccount).withdraw(50.0);
    }

    @Test
    public void testChangePin() {
        // Stubbing the behavior of the authenticator
        doNothing().when(mockAuthenticator).changePin("5678");
        // Test the changePin method
        atmOperations.changePin("5678");
        // Verify that the PIN was changed
        verify(mockAuthenticator).changePin("5678");
    }
}

