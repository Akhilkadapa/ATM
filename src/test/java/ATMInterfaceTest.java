
import core.ATMOperations;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import UI.ATMInterface;
import UI.UserInput;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ATMInterfaceTest {

    private ATMOperations mockATMOperations;
    private UserInput mockUserInput;
    private ATMInterface atmInterface;

    @Before
    public void setUp() {
        mockATMOperations = Mockito.mock(ATMOperations.class);
        mockUserInput = Mockito.mock(UserInput.class);
        atmInterface = new ATMInterface(mockATMOperations, mockUserInput);
    }

    @Test
    public void testStart_AuthenticationSuccess_DisplayBalance() {
        // Stub user input for PIN
        when(mockUserInput.getUserCommand()).thenReturn("1234");

        // Stub authentication to return true
        when(mockATMOperations.authenticate("1234")).thenReturn(true);

        // Stub user input for exit
        when(mockUserInput.getUserCommand()).thenReturn("1", "4"); // Provide input for balance enquiry and exit

        // Call the method under test
        atmInterface.start();

        // Verify that the methods were called as expected
        verify(mockATMOperations).authenticate("1234");
        verify(mockATMOperations).displayBalance();
    }

}
