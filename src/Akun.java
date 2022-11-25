public class Akun {
    private String username;

    private String pin; //

    public Akun(String username, String pin) {
        setUsername(username);
        setPin(pin);

    }

    public boolean validasiPin(String pin) {
        if (pin.equals(getPin())) {
            return true;
        }
        else {
            return false;
        }
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}