public class AkunNasabah extends Akun {
    private int saldo;

    public AkunNasabah(String username, String nomorRekening, String pin, int saldo) {
        super( username, nomorRekening, pin);
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int totalSaldo) {
        this.saldo = totalSaldo;
    }
}

