
import static org.junit.Assert .*;
import org.junit.Test;
import authenticator.AuthenticationManager;

public class AuthenticationTest {


    @Test
    public void testValidatePin() {
        AuthenticationManager authenticator = new AuthenticationManager("1234");

        assertTrue(authenticator.validatePin("1234"));
        assertFalse(authenticator.validatePin("0000")); // Incorrect PIN
    }

    @Test
    public void testChangePin() {
        AuthenticationManager authenticator = new AuthenticationManager("1234");

        authenticator.changePin("4321");
        assertTrue(authenticator.validatePin("4321")); // New PIN should be valid
        assertFalse(authenticator.validatePin("1234")); // Old PIN should be invalid
    }
}
