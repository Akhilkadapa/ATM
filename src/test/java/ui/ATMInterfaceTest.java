package ui;

import authenticator.AuthenticatorManager;
import core.ATMOperations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ATMInterfaceTest {
    private ATMOperations atmOperations;
    private UserInput userInput;
    private ATMInterface atmInterface;

    @BeforeEach
    public void setup() {
        atmOperations = mock(ATMOperations.class);
        userInput = mock(UserInput.class);
        atmInterface = new ATMInterface(atmOperations, userInput);
    }

    @Test
    public void testStart() {
        AuthenticatorManager authenticator = mock(AuthenticatorManager.class);
        when(atmOperations.getAuthenticator()).thenReturn(authenticator);
        when(authenticator.getMaxFailedAttempts()).thenReturn(3);
        when(userInput.getUserCommand(anyString())).thenReturn("1234", "1", "4");
        when(atmOperations.authenticate("1234")).thenReturn(true);

        atmInterface.start();

        verify(atmOperations, times(1)).getAuthenticator();
        verify(authenticator, times(1)).getMaxFailedAttempts();
        verify(userInput, times(3)).getUserCommand(anyString());
        verify(atmOperations, times(1)).authenticate("1234");
        verify(atmOperations, times(1)).displayBalance();
    }
}
