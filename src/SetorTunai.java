/**
 * Fungsi dari class ini adalah untuk membuat object dari class Transaksi.
 * Class ini digunakan ketika user memilih menu SetorTunai, dan akan menampilkan menu setor tunai.
 *
 * Class ini diturunkan dari class abstract Transaksi.
 * Jadi class ini harus mengimplementasikan method prosesTransaksi.
 *
 * Class ini ada untuk mendukung fitur setor tunai seperti pada atm dunia nyata
 * Class ini memiliki attribute jumlahSetoran dan konfirmasiJumlahSetoran
 * bertipe int yang digunakan untuk menyimpan jumlah setoran dan konfirmasi jumlah setoran.
 */

import java.util.Scanner; // import class Scanner

public class SetorTunai extends Transaksi {
    // attribute jumlahSetoran digunakan untuk menyimpan jumlah setoran
    private int jumlahSetoran;

    // attribute konfirmasiJumlahSetoran digunakan untuk menyimpan konfirmasi jumlah setoran
    private int konfirmasiJumlahSetoran;

    /**
     * Fungsi dari constructor ini adalah untuk membuat object dari class SetorTunai
     * Parameter nya berupa objAkunNasabah yang merupakan object dari class AkunNasabah
     */
    public SetorTunai(AkunNasabah objekAkunNasabah) {
        super(objekAkunNasabah);
    }

    /**
     * Fungsi dari method ini adalah untuk melakukan proses setor tunai.
     * Method ini merupakan method dari superclass Transaksi yang merupakan class abstract.
     * Method ini dibuat ulang untuk menyesuaikan dengan fitur Setor Tunai.
     *
     * Method ini akan meminta user untuk memasukkan jumlah setoran dan konfirmasi jumlah setoran.
     * Jika jumlah setoran dan konfirmasi jumlah setoran sama, maka akan menambahkan jumlah setoran ke saldo akun nasabah.
     * Jika jumlah setoran dan konfirmasi jumlah setoran tidak sama, maka akan menampilkan pesan jumlah setoran tidak sama.
     * Jika jumlah setoran kurang dari 100 ribu, maka akan menampilkan pesan minimal 100 ribu
     */
    public void prosesTransaksi() {
        // Mengambil object dari class AkunNasabah menggunakan method getObjAkunNasabah dan disimpan ke variable akunNasabah
        AkunNasabah akunNasabah = getObjAkunNasabah();
        Scanner input = new Scanner(System.in); // Membuat object dari class Scanner

        /**
         * Perulangan while dengan kondisi boolean true dibuat supaya perulangan dilakukan terus menerus.
         * Alasan dibuat terus menerurs karena ketika suatu user melakukan input yang salah atau tidak cocok dengan kondisi
         * maka perulangan nya akan diulangi lagi sampai user input yang benar atau cocok dengan kondisi
         * perulangan baru berhenti karena terdapat keyword BREAK.
         */
        while (true) {
            // Menampilkan pesan saldo saat ini
            System.out.println("\nSaldo anda saat ini adalah: " + formatUang(akunNasabah.getSaldo()));
            System.out.print("Masukkan jumlah setoran: "); // Menampilkan pesan masukkan jumlah setoran
            jumlahSetoran = input.nextInt(); // Mengambil input dari user dan disimpan ke variable jumlahSetoran
            System.out.print("Konfirmasi jumlah setoran: "); // Menampilkan pesan konfirmasi jumlah setoran
            // Mengambil input dari user dan disimpan ke variable konfirmasiJumlahSetoran
            konfirmasiJumlahSetoran = input.nextInt();

            // Jika jumlah setoran dan konfirmasi jumlah setoran sama
            if (jumlahSetoran == konfirmasiJumlahSetoran) {
                // Jika jumlah setoran kurang dari 100 ribu
                if (jumlahSetoran >= 100000) {
                    // jika 2 statement if diatas terpenuhi maka akan menjalan kode dibawah ini
                    // Menambahkan jumlah setoran ke saldo akun nasabah yang sedang login sekarang
                    // dengan menggunakan method setSaldo
                    akunNasabah.setSaldo(akunNasabah.getSaldo() + jumlahSetoran);
                    System.out.println("Setoran berhasil"); // Menampilkan pesan setoran berhasil
                    // Menampilkan jumlah setoran dengan memanggil method formatUang
                    // supaya formatnya menjadi rupiah
                    System.out.println("Jumlah setoran: " + formatUang(jumlahSetoran));
                    // Menampilkan saldo akun nasabah yang sedang login sekarang setelah melakukakan setor tunai
                    System.out.println("Saldo anda saat ini adalah: " + formatUang(akunNasabah.getSaldo()));
                    break; // Perulangan dihentikan
                } else {
                    // Jika jumlah setoran kurang dari 100 ribu maka akan menjalankan kode dibawah ini
                    // Perulangan dilanjutkan kembali sampai user memasukkan input yang benar
                    System.out.println("\nJumlah setoran minimal Rp100.000");
                }
            } else {
                // Jika jumlah setoran dan konfirmasi jumlah setoran tidak sama maka akan menjalankan kode dibawah ini
                // Perulangan dilanjutkan kembali sampai user memasukkan input yang benar
                System.out.println("\nJumlah setoran tidak sama");
            }
        }
    }
}


