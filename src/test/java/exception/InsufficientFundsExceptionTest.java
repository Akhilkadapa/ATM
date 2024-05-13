package exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsufficientFundsExceptionTest {
    @Test
    public void testExceptionMessage() {
        String message = "Insufficient funds";
        InsufficientFundsException exception = new InsufficientFundsException(message);
        assertEquals(message, exception.getMessage());
    }
}
