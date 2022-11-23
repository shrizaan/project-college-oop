public class Akun {
    private String username;

    private String pin; // PIN for authentication


    public Akun(String username, String pin)
    {
        setUsername(username);
        setPin(pin);

    }

    // determines whether a user-specified PIN matches PIN in Account
    public boolean validasiPIN(String userPIN)
    {
        if (userPIN == getPin())
            return true;
        else
            return false;
    } // end method validatePIN


    public String getPin(){
        return pin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

}