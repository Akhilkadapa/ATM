package authenticator;

public class AuthenticatorManager {
    private String pin;
    private int failedAttempts;
    private static final int MAX_FAILED_ATTEMPTS = 3;
    private boolean lockedOut;

    public AuthenticatorManager(String pin) {
        this.pin = pin;
        this.failedAttempts = 0;
        this.lockedOut = false;
    }

    public boolean validatePin(String inputPin) {
        if (lockedOut) {
            System.out.println("Account is locked . Please contact customer support.");
            return false;
        }
        if (pin.equals(inputPin)) {
            resetFailedAttempts(); // Reset failed attempts on successful login
            return true;
        } else {
            incrementFailedAttempts();
            if (isLockoutThresholdReached()) {
                lockoutUser();
            }
            return false;
        }
    }

    public boolean isLockedOut() {
        return lockedOut;
    }

    private void incrementFailedAttempts() {
        failedAttempts++;
    }

    private boolean isLockoutThresholdReached() {
        return failedAttempts >= MAX_FAILED_ATTEMPTS;
    }

    private void lockoutUser() {
        lockedOut = true;
        System.out.println("Account locked. Please contact customer service. Too many failed login attempts.");
        return;
    }

    private void resetFailedAttempts() {
        failedAttempts = 0;
    }

    public void changePin(String newPin) {
        if (newPin.length() != 4) {
            throw new IllegalArgumentException("PIN must be 4 digits long");
        }
        this.pin = newPin;
        resetFailedAttempts(); // Reset failed attempts when changing PIN
        System.out.println("PIN changed successfully");
    }


}
