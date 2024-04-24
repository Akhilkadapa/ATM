import java.authenticator.AuthenticatorManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AuthenticatorManagerTest {

    @Test
    public void testValidatePin() {
        AuthenticatorManager authenticator = new AuthenticatorManager("1234");
        assertTrue(authenticator.validatePin("1234"));
        assertFalse(authenticator.validatePin("4321"));
    }

    @Test
    public void testChangePin() {
        AuthenticatorManager authenticator = new AuthenticatorManager("1234");
        authenticator.changePin("4321");
        assertTrue(authenticator.validatePin("4321"));
    }

    @Test
    public void testChangePinWithInvalidLength() {
        AuthenticatorManager authenticator = new AuthenticatorManager("1234");
        assertThrows(IllegalArgumentException.class, () -> authenticator.changePin("432"));
    }
}
