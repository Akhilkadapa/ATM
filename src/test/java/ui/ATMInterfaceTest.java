package ui;

import core.ATMOperations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class ATMInterfaceTest {

    @Mock
    private ATMOperations mockATMOperations;

    @Mock
    private UserInput mockUserInput;

    private ATMInterface atmInterface;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        atmInterface = new ATMInterface(mockATMOperations, mockUserInput);
    }

    @Test
    void testSuccessfulLoginAndBalanceEnquiry() {
        when(mockUserInput.getUserCommand("Enter your PIN:")).thenReturn("1234");
        when(mockATMOperations.authenticate("1234")).thenReturn(true);
        when(mockUserInput.getUserCommand("Enter your choice:")).thenReturn("1");

        atmInterface.start();

        verify(mockATMOperations).displayBalance();
        verifyNoMoreInteractions(mockATMOperations);
    }

    @Test
    void testInvalidLoginAttemptsAndExit() {
        when(mockUserInput.getUserCommand("Enter your PIN:")).thenReturn("0000");
        when(mockATMOperations.authenticate("0000")).thenReturn(false);
        when(mockUserInput.getUserCommand("Enter your choice:")).thenReturn("4");

        atmInterface.start();

        verify(mockATMOperations, never()).displayBalance();
        verify(mockATMOperations).getAuthenticator();
        verifyNoMoreInteractions(mockATMOperations);
    }

    @Test
    void testWithdrawMoney() {
        when(mockUserInput.getUserCommand("Enter your PIN:")).thenReturn("1234");
        when(mockATMOperations.authenticate("1234")).thenReturn(true);
        when(mockUserInput.getUserCommand("Enter your choice:")).thenReturn("2");
        when(mockUserInput.getAmount()).thenReturn(100.0);

        atmInterface.start();

        verify(mockATMOperations).withdrawMoney(100.0);
        verifyNoMoreInteractions(mockATMOperations);
    }

    @Test
    void testChangePin() {
        when(mockUserInput.getUserCommand("Enter your PIN:")).thenReturn("1234");
        when(mockATMOperations.authenticate("1234")).thenReturn(true);
        when(mockUserInput.getUserCommand("Enter your choice:")).thenReturn("3");
        when(mockUserInput.getNewPin()).thenReturn("4321");

        atmInterface.start();

        verify(mockATMOperations).changePin("4321");
        verifyNoMoreInteractions(mockATMOperations);
    }

    @Test
    void testInvalidChoice() {
        when(mockUserInput.getUserCommand("Enter your PIN:")).thenReturn("1234");
        when(mockATMOperations.authenticate("1234")).thenReturn(true);
        when(mockUserInput.getUserCommand("Enter your choice:")).thenReturn("5");

        atmInterface.start();

        verify(mockATMOperations, never()).displayBalance();
        verifyNoMoreInteractions(mockATMOperations);
    }
}
