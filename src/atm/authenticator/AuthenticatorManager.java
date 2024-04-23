package authenticator;


public class AuthenticatorManager {
    private String pin;

    public AuthenticatorManager(String pin) {
        this.pin = pin;
    }

    public boolean validatePin(String inputPin) {
        return pin.equals(inputPin);
    }

    public void changePin(String newPin) {
        if (newPin.length() != 4) {
            throw new IllegalArgumentException("PIN must be 4 digits long");
        }
        this.pin = newPin;
        System.out.println("PIN changed successfully");
    }
}



