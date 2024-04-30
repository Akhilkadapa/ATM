import UI.ATMInterface;
import UI.UserInput;
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
        // Define behavior for getUserCommand() mock
        when(userInput.getUserCommand()).thenReturn("1234", "1", "4"); // Provide predefined input

        // Define behavior for authenticate() mock
        when(atmOperations.authenticate(anyString())).thenReturn(true);

        // Execute the method under test
        atmInterface.start();

        // Verify that displayBalance() is called once
        verify(atmOperations, times(1)).displayBalance();
    }

    @Test
    public void testWithdrawMoney() {
        // Define behavior for getAmount() mock
        when(userInput.getUserCommand()).thenReturn("1234", "2", "4"); // Provide predefined input
        when(userInput.getAmount()).thenReturn(100.0);

        // Define behavior for authenticate() mock
        when(atmOperations.authenticate(anyString())).thenReturn(true);

        // Execute the method under test
        atmInterface.start();

        // Verify that withdrawMoney() is called once with the correct amount
        verify(atmOperations, times(1)).withdrawMoney(100.0);
    }
}
