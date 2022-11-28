/**
 * Fungsi dari class ini digunakan untuk membuat object bertipe Transfer.
 * Class ini ada untuk mendukung fitur transfer seperti ATM pada dunia nyata.
 * Class ini dipakai ketika user memilih menu transfer.
 *
 * Class ini merupakan turunan dari class abstract transaksi
 * yang berarti class ini harus mengimplementasikan method prosesTransaksi.
 *
 * Class ini memiliki attribute nomorRekeningTujuang bertipe string, jumlahTransfer
 * dan konfirmasiJumalhTransfer bertipe int.
 */

import java.util.Scanner; // import class Scanner untuk input dari user

public class Transfer extends Transaksi {
    // attribute nomorRekeningTujuan digunakan untuk menyimpan nomor rekening tujuan
    private String nomorRekeningTujuan;
    // attribute jumlahTransfer digunakan untuk menyimpan jumlah transfer
    private int jumlahTransfer;
    // attribute konfirmasiJumlahTransfer digunakan untuk menyimpan konfirmasi jumlah transfer
    private int konfirmasiJumlahTransfer;

    /**
     * Fungsi dari constructor ini adalah untuk membuat object dari class Transfer
     * Dengan parameter objekAkunNasabah yang merupakan object dari class AkunNasabah
     */
    public Transfer(AkunNasabah objekAkunNasabah) {
        super(objekAkunNasabah);
    }

    /**
     * Fungsi dari method ini untuk melakukan proses transfer dari akun nasabah yang sedang login.
     * Method ini merupakan method dari superclass Transaksi yang merupakan class abstract.
     * Method ini dibuat ulang untuk menyesuaikan dengan fitur transfer.
     *
     * Method ini memiliki 3 proses utama yaitu:
     * 1. Memasukkan nomor rekening tujuan
     * 2. Memasukkan jumlah transfer
     * 3. Melakukan konfirmasi jumlah transfer
     *
     * Method ini Melakukan pengecekan apakah jumlah transfer yang dimasukkan sesuai dengan saldo yang ada.
     * dengan menggunakan attribute jumlahTransfer dan konfirmasiJumlahTransfer
     *
     * Method ini  memiliki 2 proses yang terjadi ketika proses transfer berhasil yaitu:
     * 1. Mengurangi saldo dari akun nasabah yang sedang login
     * 2. Menambahkan saldo dari akun nasabah tujuan
     */
    public void prosesTransaksi() {
        // Membuat variabel akunNasabah bertipe AkunNasabah untuk menyimpan object akun nasabah yang sedang login
        AkunNasabah akunNasabah = getObjAkunNasabah();
        Scanner input = new Scanner(System.in); // Membuat object input dari class Scanner untuk input dari user

        // Menampilkan pesan untuk memasukkan nomor rekening tujuan
        System.out.print("\nMasukkan nomor rekening tujuan: ");
        nomorRekeningTujuan = input.nextLine(); //  Memasukkan nomor rekening tujuan ke dalam attribute nomorRekeningTujuan

        /**
         * Perulangan while dengan kondisi boolean true dibuat supaya perulangan dilakukan terus menerus.
         * Alasan dibuat terus menerurs karena ketika suatu user melakukan input yang salah atau tidak cocok dengan kondisi
         * maka perulangan nya akan diulangi lagi sampai user input yang benar atau cocok dengan kondisi
         * perulangan baru berhenti karena terdapat keyword BREAK.
         */
        while (true) {
            // Menampilkan pesan untuk memasukkan jumlah transfer
            System.out.print("Masukkan jumlah transfer: ");
            jumlahTransfer = input.nextInt(); // Memasukkan jumlah transfer ke dalam attribute jumlahTransfer
            // Menampilkan pesan untuk memasukkan konfirmasi jumlah transfer
            System.out.print("Konfirmasi jumlah transfer: ");
            // Memasukkan konfirmasi jumlah transfer ke dalam attribute konfirmasiJumlahTransfer
            konfirmasiJumlahTransfer = input.nextInt();

            // Pengecekan apakah jumlah transfer dan konfirmasi jumlah transfer sama
            if (jumlahTransfer == konfirmasiJumlahTransfer) {
                // Pengecekan apakah jumlah transfer lebih kecil dari saldo yang ada
                if (jumlahTransfer >= 100000) {
                    // Pengecekan apakah jumlah transfer lebih kecil dari saldo yang ada
                    if (jumlahTransfer < akunNasabah.getSaldo()) {
                        // Mengurangi saldo dari akun nasabah yang sedang login
                        akunNasabah.setSaldo(akunNasabah.getSaldo() - jumlahTransfer);

                        System.out.println("\nTransfer berhasil"); // Menampilkan pesan transfer berhasil
                        // Menampilkan pesan informasi nomor rekening tujuan yang dimasukkan sebelumnya
                        System.out.println("Nomor Rekening Tujuan: " + nomorRekeningTujuan);
                        // Menampilkan pesan informasi jumlah transfer yang dimasukkan sebelumnya
                        System.out.println("Jumlah transfer: " + formatUang(jumlahTransfer));
                        // Menampilkan pesan informasi saldo akun nasabah yang sedang login setelah melakukan transfer
                        System.out.println("Saldo anda saat ini adalah: " + formatUang(akunNasabah.getSaldo()));
                        break; // Perulangan dihentikan
                    } else {
                        // Menampilkan pesan jika jumlah transfer lebih besar dari saldo yang ada
                        System.out.println("\nMaaf, saldo anda tidak mencukupi");
                        break; // Perulangan dihentikan
                    }
                } else {
                    // Menampilkan pesan jika jumlah transfer kurang dari 100.000
                    // Perulangan dilanjutkan kembali sampai user memasukkan input yang benar
                    System.out.println("\nJumlah transfer minimal Rp100.000\n");
                }
            } else {
                // Menampilkan pesan jika jumlah transfer dan konfirmasi jumlah transfer tidak sama
                // Perulangan dilanjutkan kembali sampai user memasukkan input yang benar
                System.out.println("\nJumlah transfer tidak sama\n");
            }
        }
    }
}
