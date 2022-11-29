public class  Akun implements ValidasiNomorRekening, ValidasiPin {
    protected String username;
    protected String nomorRekening;
    protected String pin;

    public Akun(String username, String nomorRekening, String pin) {
        this.nomorRekening = nomorRekening;
        this.username = username;
        this.pin = pin;
    }

    public boolean validasiNomorRekening(String nomorRekening) {
        if (nomorRekening.equals(this.nomorRekening)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean validasiPin(String pin) {
        if (pin.equals(this.pin)) {
            return true;
        }
        else {
            return false;
        }
    }
}