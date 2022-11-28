// AkunNasabah.java
// Merepresentasikan akun nasabah

public class AkunNasabah extends Akun
{
    private int saldo;

    public AkunNasabah(String username, String nomorRekening, String pin, int saldo) {
        super( username, nomorRekening, pin);
        setSaldo(saldo);
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int totalSaldo) {
            this.saldo = totalSaldo;
    }


}

