import UI.UserInput;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class UserInputTest {

    private final InputStream originalSystemIn = System.in;
    private final ByteArrayInputStream mockInput = new ByteArrayInputStream("test\nabc\n100.0\n4321\n".getBytes());

    @Before
    public void setUp() {
        System.setIn(mockInput);
    }

    @After
    public void tearDown() {
        System.setIn(originalSystemIn);
    }

    @Test
    public void testGetUserCommand() {
        UserInput userInput = new UserInput();
        assertEquals("test", userInput.getUserCommand());
    }

    @Test
    public void testGetAmount() {
        UserInput userInput = new UserInput();
        // First attempt: non-numeric input
        System.out.println("Expected output: 'Invalid input. Please enter a valid number.'");
        assertEquals(100.0, userInput.getAmount(), 0.001);

        // Second attempt: valid numeric input
        assertEquals(4321.0, userInput.getAmount(), 0.001);
    }

    @Test
    public void testGetNewPin() {
        UserInput userInput = new UserInput();
        assertEquals("test", userInput.getNewPin());
    }

}

