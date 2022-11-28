/**
 * Fungsi dari class ini adalah untuk mengganti pin dari akun nasabah.
 * Class ini memiliki method gantiPin yang akan mengganti pin dari akun nasabah.
 * Class ini digunakan ketika user memilih menu ganti pin.
 * Class ini merupakan subclass dari superclass Transaksi.
 * Class ini memiliki attribute pinLama dan pinBaru bertipe String yang digunakan untuk menyimpan pin lama dan pin baru.
 * Class ini memiliki method prosesTransaksi yang merupakan method dari superclass Transaksi yang merupakan class abstract.
 * Method prosesTransaksi meng-override method prosesTransaksi dari superclass Transaksi.
 */

import java.util.Scanner;

public class GantiPIN extends Transaksi {
    // attribute pinLama digunakan untuk menyimpan pin lama
    private String pinLama;
    // attribute pinBaru digunakan untuk menyimpan pin baru
    private String pinBaru;
    // attribute konfirmasiPinBaru digunakan untuk menyimpan konfirmasi pin baru
    private String konfirmasiPinBaru;

    /**
     * Fungsi dari constructor ini adalah untuk membuat object dari class GantiPIN.
     * Parameternya berupa objekAkunNasabah bertipe AkunNasabah.
     */
    public GantiPIN(AkunNasabah objekAkunNasabah) {
        super(objekAkunNasabah);
    }

    /**
     * Fungsi dari method ini adalah untuk mengganti pin dari akun nasabah.
     * Method ini merupakan method dari superclass Transaksi yang merupakan class abstract.
     * Method ini dibuat ulang untuk menyesuaikan dengan fitur ganti pin.
     */
    public void prosesTransaksi() {
        // Memanggil method getObjAkunNasabah dari superclass Transaksi untuk mengambil objekAkunNasabah
        AkunNasabah akunNasabah = getObjAkunNasabah();
        // membuat object dari class Scanner untuk mengambil input dari user
        Scanner input = new Scanner(System.in);

        // menampilkan pesan untuk memasukkan pin lama
        System.out.print("\nMasukkan PIN lama: ");
        pinLama = input.nextLine(); // mengambil input dari user dan menyimpannya ke dalam attribute pinLama

        // mengecek apakah pin lama yang dimasukkan sama dengan pin dari akun nasabah yang sedang login
        if (pinLama.equals(akunNasabah.getPin())) {
            /**
             * Perulangan while dengan kondisi boolean true dibuat supaya perulangan dilakukan terus menerus.
             * Alasan dibuat terus menerurs karena ketika suatu user melakukan input yang salah atau tidak cocok dengan kondisi
             * maka perulangan nya akan diulangi lagi sampai user input yang benar atau cocok dengan kondisi
             * perulangan baru berhenti karena terdapat keyword BREAK.
             */
            while (true) {
                // menampilkan pesan untuk memasukkan pin baru
                System.out.print("Masukkan PIN baru: ");
                pinBaru = input.nextLine(); // mengambil input dari user dan menyimpannya ke dalam attribute pinBaru
                // menampilkan pesan untuk memasukkan konfirmasi pin baru
                System.out.print("Konfirmasi PIN baru: ");
                // mengambil input dari user dan menyimpannya ke dalam attribute konfirmasiPinBaru
                konfirmasiPinBaru = input.nextLine();

                // mengecek apakah pin baru dan konfirmasi pin baru sama
                if (pinBaru.equals(konfirmasiPinBaru)) {
                    // mengganti pin dari akun nasabah dengan pin baru
                    akunNasabah.setPin(pinBaru);
                    System.out.println("\nPIN berhasil diganti"); // menampilkan pesan bahwa pin berhasil diganti
                    break; // perulangan dihentikan dengan keyword break
                } else {
                    // menampilkan pesan bahwa pin baru dan konfirmasi pin baru tidak sama
                    // dan perulangan akan diulangi lagi karena tidak ada keyword break
                    System.out.println("\nPIN baru tidak sama\n");
                }
            }
        } else {
            // menampilkan pesan bahwa pin lama yang dimasukkan
            // tidak sama dengan pin dari akun nasabah yang sedang login
            // dan perulangan akan diulangi lagi karena tidak ada keyword break
            System.out.println("\nPIN lama salah");
        }
    }
}
