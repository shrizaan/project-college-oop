public class Akun implements ValidasiNomorRekening, ValidasiPin {
    private String username;

    private String nomorRekening;
    private String pin; //

    public Akun(String username, String nomorRekening, String pin) {
        setNomorRekening(nomorRekening);
        setUsername(username);
        setPin(pin);
    }

    public boolean validasiNomorRekening(String nomorRekening) {
        if (nomorRekening.equals(getNomorRekening()))
            return true;
        else
            return false;
    }

    public boolean validasiPin(String pin) {
        if (pin.equals(getPin())) {
            return true;
        }
        else {
            return false;
        }
    }

    public String getNomorRekening()
    {
        return nomorRekening;
    }

    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
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