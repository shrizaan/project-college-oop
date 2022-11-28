/**
 * Fungsi class ini untuk membuat object dari class AkunNasabah.
 * Class ini digunakan ketika membuat object dari class DatabaseAkun dan akan disimpan didalam array databaseAKun
 * Class ini merupakan subclass dari superclass Akun.
 * Class ini memiliki attribute saldo bertipe double yang digunakan untuk menyimpan saldo dari nasabah.
 */
public class AkunNasabah extends Akun
{
    private int saldo;

    /**
     * Fungsi dari constructor ini adalah untuk membuat object dari class AkunNasabah
     * dengan paramter username, nomorRekening, pin, saldo
     */
    public AkunNasabah(String username, String nomorRekening, String pin, int saldo) {
        // memanggil method super dari class Akun untuk mengisi attribute username, nomorRekening, dan pin
        super( username, nomorRekening, pin);
        // mengisi attribute saldo dengan parameter saldo
        setSaldo(saldo);
    }

    /**
     * Fungsi dari method ini adalah untuk mengembalikan nilai dari attribute saldo
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * Fungsi dari method ini adalah untuk mengubah nilai dari attribute saldo
     * menerima parameter berupa nilai saldo
     */
    public void setSaldo(int totalSaldo) {
            this.saldo = totalSaldo;
    }
}

