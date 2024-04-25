
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
        when(userInput.getUserCommand()).thenReturn("1234", "1", "4");
        when(atmOperations.authenticate(anyString())).thenReturn(true);

        atmInterface.start();

        verify(atmOperations, times(1)).displayBalance();
    }

    @Test
    public void testWithdrawMoney() {
        when(userInput.getUserCommand()).thenReturn("1234", "2", "4");
        when(userInput.getAmount()).thenReturn(100.0);
        when(atmOperations.authenticate(anyString())).thenReturn(true);

        atmInterface.start();

        verify(atmOperations, times(1)).withdrawMoney(100.0);
    }


}
