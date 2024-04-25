import UI.UserInput;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class UserInputTest {
    private final InputStream systemIn = System.in;
    private ByteArrayInputStream testIn;
    private UserInput userInput;

    @Before
    public void setUp() {
        userInput = new UserInput();
    }

    @After
    public void tearDown() {
        restoreSystemInput();
    }

    @Test
    public void testGetUserCommand() {
        String input = "command";
        provideTestInput(input);

        String result = userInput.getUserCommand();

        assertEquals(input, result);
    }

    @Test
    public void testGetAmount() {
        double amount = 100.0;
        provideTestInput(Double.toString(amount));

        double result = userInput.getAmount();

        assertEquals(amount, result, 0.001);
    }

    @Test
    public void testGetNewPin() {
        String pin = "1234";
        provideTestInput(pin);

        String result = userInput.getNewPin();

        assertEquals(pin, result);
    }

    private void provideTestInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private void restoreSystemInput() {
        System.setIn(systemIn);
    }
}
