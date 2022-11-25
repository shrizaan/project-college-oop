// AkunNasabah.java
// Merepresentasikan akun nasabah

public class AkunNasabah extends Akun
{
    private String nomorRekening;
    private int saldo;

    public AkunNasabah(String username, String nomorRekening, String pin, int saldo) {
        super( username, pin);
        setNomorRekening(nomorRekening);
        setSaldo(saldo);
    }

    public boolean validasiNomorRekening(String nomorRekening) {
        if (nomorRekening.equals(getNomorRekening()))
            return true;
        else
            return false;
    }


    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int totalSaldo) {
            this.saldo = totalSaldo;
    }


}

