/**
 * Fungsi class ini digunakan untuk membuat object bertipe TarikTunai
 * Class ini digunakan ketika user melakukan input memilih untuk menarik tunai dari saldo akun nasabah.
 * Class ini ada untuk mendukung fitur TarikTunai seperti ATM pada dunia nyata.
 *
 * Class ini memiliki attribute jumlahPenarikan dan konfirmasiPenarikan bertipe int yang digunakan
 * untuk menyimpan jumlah penarikan dan konfirmasi penarikan dari akun nasabah yang sedang login.
 *
 * Class ini memiliki method prosesTransaksi yang merupakan
 * method dari superclass Transaksi yang merupakan class abstract.
 *
 */

import java.util.Scanner; // import Scanner class

// Class TarikTunai merupakan subclass dari class Transaksi
public class TarikTunai extends Transaksi {
    // attribute jumlahPenarikan digunakan untuk menyimpan
    // jumlah penarikan dari akun nasabah yang sedang login
    private int jumlahPenarikan;
    // attribute konfirmasiJumlahPenarikan digunakan untuk
    // menyimpan variabel konfirmasi jumlah penarikan
    private int konfirmasiJumlahPenarikan;

    /**
     * Fungsi dari constructor ini adalah untuk membuat object dari class TarikTunai
     */
    public TarikTunai(AkunNasabah objekAkunNasabah) {
        // memanggil constructor superclass Transaksi dengan parameter objekAkunNasabah
        super(objekAkunNasabah);
    }

    /**
     * Fungsi dari method ini untuk melakukan proses penarikan tunai.
     * Method ini merupakan method dari superclass Transaksi yang merupakan class abstract.
     * Method ini dibuat ulang untuk menyesuaikan dengan fitur Tarik Tunai.
     *
     * Method ini akan meminta user untuk memasukkan jumlah penarikan dan konfirmasi jumlah penarikan.
     * Jika jumlah penarikan dan konfirmasi jumlah penarikan sama, maka akan dilakukan penarikan tunai.
     *
     * Jika jumlah penarikan dan konfirmasi jumlah penarikan tidak sama,
     * maka akan ditampilkan pesan penarikan tidak sama.
     *
     * Jika jumlah penarikan lebih besar dari saldo,
     * maka akan ditampilkan pesan penarikan lebih besar dari saldo.
     *
     * Jika jumlah penarikan kurang dari 10000, maka akan ditampilkan pesan penarikan minimal 10000.
     */
    public void prosesTransaksi() {
        Scanner input = new Scanner(System.in); // membuat object scanner

        /**
         * Perulangan while dengan kondisi boolean true dibuat supaya perulangan dilakukan terus menerus.
         * Alasan dibuat terus menerurs karena ketika suatu user
         * melakukan input yang salah atau tidak cocok dengan kondisi.
         * maka perulangan nya akan diulangi lagi sampai
         * user input yang benar atau cocok dengan kondisi
         * perulangan baru berhenti karena terdapat keyword BREAK.
         */
        while(true)  {
            // menampilkan pesan jumlah saldo nasabah saat ini dalam format rupiah
            System.out.println("\nSaldo anda saat ini adalah: " + formatUang(objekAkunNasabah.getSaldo()));
            // menampilkan pesan untuk memasukkan jumlah penarikan
            System.out.print("Masukkan jumlah penarikan: ");
            jumlahPenarikan = input.nextInt(); // input jumlah penarikan
            // menampilkan pesan untuk memasukkan konfirmasi jumlah penarikan
            System.out.print("Konfirmasi jumlah penarikan: ");
            konfirmasiJumlahPenarikan = input.nextInt(); // input konfirmasi jumlah penarikan

            // jika jumlah penarikan dan konfirmasi jumlah penarikan sama
            if (jumlahPenarikan == konfirmasiJumlahPenarikan) {
                // jika jumlah penarikan lebih besar dari 100 ribu
                if (jumlahPenarikan >= 100000){
                    // jika jumlah penarikan lebih besar dari saldo
                    if (jumlahPenarikan > objekAkunNasabah.getSaldo()) {
                        // menampilkan pesan penarikan lebih besar dari saldo
                        System.out.println("\nMaaf, saldo anda tidak mencukupi");
                        break; // menhentikan perulangan dengan keyword break dan kembali ke menu utama
                    } else {
                        // mengurangi saldo dengan jumlah penarikan dengan method setSaldo
                        objekAkunNasabah.setSaldo(objekAkunNasabah.getSaldo() - jumlahPenarikan);
                        // menampilkan pesan penarikan berhasil
                        System.out.println("\nPenarikan berhasil");
                        // menampilkan pesan jumlah penarikan yang telah dilakukan dalam format rupiah
                        System.out.println("Jumlah penarikan: " + formatUang(jumlahPenarikan));
                        // menampilkan pesan jumlah saldo nasabah saat ini dalam format rupiah
                        System.out.println("Saldo anda saat ini adalah: " + formatUang(objekAkunNasabah.getSaldo()));
                        break; // menghentikan perulangan dengan keyword break dan kembali ke menu utama
                    }
                } else {
                    // menampilkan pesan penarikan minimal 100 ribu
                    // dan melakukan perulangan lagi sampai user input yang benar
                    System.out.println("\nJumlah penarikan minimal Rp100.000");
                }
            } else {
                // menampilkan pesan penarikan tidak sama
                // dan melakukan perulangan lagi sampai user input yang benar
                System.out.println("\nJumlah penarikan tidak sama");
            }

        }
    }
}
