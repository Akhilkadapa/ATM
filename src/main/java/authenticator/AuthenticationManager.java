package authenticator;

public class AuthenticationManager {

    private String pin;

    public AuthenticationManager(String pin) {
        this.pin = pin;
    }

    public boolean validatePin(String inputPin) {
        return pin.equals(inputPin);
    }

    public void changePin(String newPin) {
        try {
            if (newPin.length() != 4) {
                throw new IllegalArgumentException("PIN must be 4 digits long");
            }
            this.pin = newPin;
            System.out.println("PIN changed successfully");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
