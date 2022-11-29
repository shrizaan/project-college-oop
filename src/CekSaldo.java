/**
 * Fungsi class ini adalah untuk cek saldo akun nasabah yang sedang login.
 * Class ini ada untuk mendukung fitur cek saldo seperti ATM pada dunia nyata.
 * Class ini dipakai ketika user memilih menu cek saldo.
 * Class ini memiliki attribute saldoObjekNasabah bertipe int yang digunakan
 * untuk menyimpan saldo dari akun nasabah yang sedang login.
 *
 * Class ini memiliki method prosesTransaksi yang merupakan
 * method dari superclass Transaksi yang merupakan class abstract.
 * Method prosesTransaksi ini dibuat ulang untuk menyesuaikan dengan fitur cek saldo.
 */
public class CekSaldo extends Transaksi {
    // attribute saldoObjekNasabah digunakan untuk menyimpan saldo dari akun nasabah yang sedang login
    private int saldoObjekNasabah;

    /**
     * Fungsi dari constructor ini adalah untuk membuat object dari class CekSaldo
     * Parameter nya berupa objAkunNasabah yang merupakan object dari class AkunNasabah
     */
    public CekSaldo(AkunNasabah objAkunNasabah) {
        super(objAkunNasabah);
    }

    /**
     * Fungsi dari method ini adalah untuk mengecek saldo dari akun nasabah yang sedang login
     * Parameter nya berupa saldoObjekNasabah yang merupakan saldo dari akun nasabah yang sedang login
     */
    public void setSaldoObjekNasabah(int saldoObjekNasabah) {
        this.saldoObjekNasabah = saldoObjekNasabah;
    }

    /**
     * Fungsi dari method ini adalah untuk menampilkan saldo dari akun nasabah yang sedang login
     * Mengembalikan / return saldoObjekNasabah yang merupakan saldo
     * dari akun nasabah yang sedang login
     */
    public int getSaldoObjekNasabah() {
        return saldoObjekNasabah;
    }

    /**
     * Fungsi dari method ini adalah untuk menampilkan saldo dari akun nasabah yang sedang login
     * Method ini merupakan method dari superclass Transaksi yang merupakan class abstract.
     * Method ini dibuat ulang untuk menyesuaikan dengan fitur cek saldo.
     */
    public void prosesTransaksi() {
        setSaldoObjekNasabah(objekAkunNasabah.getSaldo());
        System.out.println("\nSaldo anda saat ini adalah: " + formatUang(getSaldoObjekNasabah()));
    }
}
