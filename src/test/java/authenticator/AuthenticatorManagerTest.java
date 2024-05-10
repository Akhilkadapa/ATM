package authenticator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthenticatorManagerTest {

    @Test
    public void testValidatePin_ValidPin() {
        AuthenticatorManager authenticator = new AuthenticatorManager("1234");
        assertTrue(authenticator.validatePin("1234"));
    }

    @Test
    public void testValidatePin_InvalidPin() {
        AuthenticatorManager authenticator = new AuthenticatorManager("1234");
        assertFalse(authenticator.validatePin("4321"));
    }

    @Test
    public void testValidatePin_LockedAccount() {
        AuthenticatorManager authenticator = new AuthenticatorManager("1234");
        authenticator.validatePin("1111"); // Incorrect attempt 1
        authenticator.validatePin("2222"); // Incorrect attempt 2
        authenticator.validatePin("3333"); // Incorrect attempt 3 (lockout threshold)
        assertTrue(authenticator.isLockedOut());
    }

    @Test
    public void testChangePin_ValidPin() {
        AuthenticatorManager authenticator = new AuthenticatorManager("1234");
        authenticator.changePin("4321");
        assertTrue(authenticator.validatePin("4321"));
    }

    @Test
    public void testChangePin_InvalidPinLength() {
        AuthenticatorManager authenticator = new AuthenticatorManager("1234");
        assertThrows(IllegalArgumentException.class, () -> authenticator.changePin("432"));
    }

    @Test
    public void testResetFailedAttempts() {
        AuthenticatorManager authenticator = new AuthenticatorManager("1234");
        authenticator.validatePin("1111"); // Incorrect attempt 1
        authenticator.resetFailedAttempts();
        assertFalse(authenticator.isLockedOut());
    }
}
