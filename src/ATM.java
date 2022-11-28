/*
* Fungsi class ini dibuat untuk menyediakan fitur fitur penting di ATM seperti login, lanjutLagi,
* dan menampilkan menuPilihan.
*
* Class ini ada untuk menyediakan fungsionalitas simulasi ATM.
*
* Class ini digunakan ketika ingin melakukan login atm dan dibuat objectnya di class Application.
* Class ini memiliki attribute objekAkun bertipe Akun yang digunakann untuk menyimpan object AkunNasabah atau AkunAdmin
* yang sedang menggunakan ATM.
* Class ini tidak menyediakan constructor.
* Class ini memiliki method login, lanjutLagin, menuPilihan pertama dengan argument AkunNasabah dan menuPilihan kedua
* dengan argument AkunAdmin
* */

import java.util.Scanner;

public class ATM  {
    private Akun objekAkun;

    // Method login digunakan untuk melakukan login ke aplikasi atm
    public void login() {
        /**
         * Perulangan while dengan kondisi boolean true dibuat supaya perulangan dilakukan terus menerus.
         * Alasan dibuat terus menerurs karena ketika suatu user melakukan input yang salah atau tidak cocok dengan kondisi
         * maka perulangan nya akan diulangi lagi sampai user input yang benar atau cocok dengan kondisi
         * perulangan baru berhenti karena terdapat keyword BREAK.
         */
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Masukkan nomor rekening: "); // meminta inputan nomorRekening ke user
            String nomorRekening = input.next(); // simpan inputan user ke variabel nomoRekening bertipe string
            System.out.print("Masukkkan nomor pin: "); // meminta inputan nomor pin ke user
            String pin = input.next(); // simpanan inputan user ke variabel pin bertipe string

            /**
             * Membuat object DatabaseAkun yang fungsinya untuk membuat seluruh akunAdmin dan akunNasabah
             * pada constructor DatabaseAkun.
             * Object databaseAkun memiliki variabel attribute arraylist yang digunakan untuk menyimpan seluruh data akun
             */
            DatabaseAkun databaseAkun = new DatabaseAkun();
            /**
             * Memanggil method getAkun dengan menggunakan object databaseAkun dengan argument nilai inputan user tadi
             * yaitu nomorRekening dan pin
             */
            objekAkun = databaseAkun.getAkun(nomorRekening, pin);

            /**
             * Melakukan pengecekan pada attribute objekAkun dengan menggunakan logika AND (&&) yang menggabungkan 2 kondisi.
             * Kondisi pertama mengecek apakah nilai objectAkun tidak sama dengan null / kosong / tidak ada nilai
             * Kondisi kedua mengecek apakah nilai objectAkun dibuat menggunakan class AkunNasabah dengan operator instanceof
             * Operator instanceof mengecek apakah suatu object benar benar dibuat dari suatu class
             * jika iya maka akan mengembalikan true
             * jika tidak maka akan mengembalikan false
             */
            if (objekAkun != null && objekAkun instanceof AkunNasabah) {
                /**
                 * (AkunNasabah) objectAkun : arti kode yaitu mengubah tipe datanya
                 *                              menjadi tipe yang ada didalam tanda kurung yaitu
                 *                              AkunNasabah
                 * Contoh lain:
                 * (String) variabelAngka: artinya kode ini mengubah variabelAngka yang awalnya bertipe integer
                 *                      menjadi bertipe string
                 */
                // memanggil method menuPilihan dengan argument objekAkun
                // dan mengubah tipe datanya menjadi bertipe AkunNasabah
                menuPilihan((AkunNasabah) objekAkun);
                break; // break digunakan untuk menghentikan perulangan

                // kode else if ini dibawah sama fungsinya dengan kondisi if diatas
                // yang membedakannya adalah pada pengecekan apakah objekAkun dibuat menggunakan class AkunAdmin
            } else if (objekAkun != null && objekAkun instanceof AkunAdmin) {
                // memanggil method menuPilihan dengan argument objekAkun dan mengubah tipe datanya menjadi bertipe AkunAdmin
                menuPilihan((AkunAdmin) objekAkun);
                break; // break digunakan untuk menghentikan perulangan
            }
            else {
                // menampilkan pesan berikut dan melakukan perulangan lagi
                System.out.println("\nNomor Rekening atau PIN tidak ada di database!\n");
            }
        }
    }

    // menuPilihan pertama dengan argument objek AkunNasabah method ini dibuat khusus untuk akunNasabah
    public void menuPilihan(AkunNasabah objekAkunNasabah) {
        Scanner scan = new Scanner(System.in); // kode ini digunakan untuk membuat object input supaya user bisa melakukan fungsi input
        /**
         * Perulangan while dengan kondisi boolean true dibuat supaya perulangan dilakukan terus menerus.
         * Alasan dibuat terus menerus karena ketika suatu user melakukan input yang salah atau tidak cocok dengan kondisi
         * maka perulangan nya akan diulangi lagi sampai user input yang benar atau cocok dengan kondisi
         * perulangan baru berhenti karena terdapat keyword BREAK.
         */
        while (true) {
            // 4 baris dibawah ini digunakan untuk menampilkan informasi nama dan nomor rekening nasabah
            System.out.println("\n|====================================|");
            System.out.println("  Nama         : " + objekAkunNasabah.getUsername());
            System.out.println("  No. Rekening : " + objekAkunNasabah.getNomorRekening());
            System.out.println("|====================================|");

            // menampilkan menu pilihan
            System.out.println("\t1. Cek Saldo");
            System.out.println("\t2. Tarik Tunai");
            System.out.println("\t3. Setor Tunai");
            System.out.println("\t4. Transfer");
            System.out.println("\t5. Ganti PIN");
            System.out.println("\t6. Keluar");
            // meminta inputan user untuk memilih menu
            System.out.print("Pilih transaksi yang ingin dilakukan: ");
            String transaksi = scan.next(); // simpan input ke variabel transaksi

            // melakukan pengecekan inputan user dengan menggunakan switch case
            switch (transaksi) {

                case "1":
                    /**
                     * jika inputan user adalah 1 maka membuat object dari class CekSaldo dengan argument objekAkunNasabah
                     * dan memanggil method prosesTransaksi()  untuk menampilkan menu cek saldo
                     * setelah proses transaksi selesai maka akan memanggil method lanjutLagi yang menanyakan
                     * apakah user ingin melakukan transaksi lagi
                     * setelah itu perulangan akan dihentikan dengan keyword break
                     */
                    CekSaldo objCekSaldo = new CekSaldo(objekAkunNasabah);
                    objCekSaldo.prosesTransaksi();
                    lanjutLagi();
                    break;
                case "2":
                    /**
                     * jika inputan user adalah 2 maka membuat object dari class TarikTunai dengan argument objekAkunNasabah
                     * dan memanggil method prosesTransaksi() untuk menampilkan menu tarik tunai
                     * setelah proses transaksi selesai maka akan memanggil method lanjutLagi yang menanyakan
                     * apakah user ingin melakukan transaksi lagi
                     * setelah itu perulangan akan dihentikan dengan keyword break
                     */
                    TarikTunai objTarikTunai = new TarikTunai(objekAkunNasabah);
                    objTarikTunai.prosesTransaksi();
                    lanjutLagi();
                    break;
                case "3":
                    /**
                     * jika inputan user adalah 2 maka membuat object dari class SetorTunai dengan argument objekAkunNasabah
                     * dan memanggil method prosesTransaksi() untuk menampilkan menu setor tunai
                     * setelah proses transaksi selesai maka akan memanggil method lanjutLagi yang menanyakan
                     * apakah user ingin melakukan transaksi lagi
                     * setelah itu perulangan akan dihentikan dengan keyword break
                     */
                    SetorTunai objSetorTunai = new SetorTunai(objekAkunNasabah);
                    objSetorTunai.prosesTransaksi();
                    lanjutLagi();
                    break;
                case "4":
                    /**
                     * jika inputan user adalah 2 maka membuat object dari class Transfer dengan argument objekAkunNasabah
                     * dan memanggil method prosesTransaksi() untuk menampilkan menu transfer
                     * setelah proses transaksi selesai maka akan memanggil method lanjutLagi yang menanyakan
                     * apakah user ingin melakukan transaksi lagi
                     * setelah itu perulangan akan dihentikan dengan keyword break
                     */
                    Transfer objTransfer = new Transfer(objekAkunNasabah);
                    objTransfer.prosesTransaksi();
                    lanjutLagi();
                    break;
                case "5":
                    /**
                     * jika inputan user adalah 2 maka membuat object dari class GantiPIN dengan argument objekAkunNasabah
                     * dan memanggil method prosesTransaksi() untuk menampilkan menu tarik tunai
                     * setelah proses transaksi selesai maka akan memanggil method ganti pin yang menanyakan
                     * apakah user ingin melakukan transaksi lagi
                     * setelah itu perulangan akan dihentikan dengan keyword break
                     */
                    GantiPIN objGantiPIN = new GantiPIN(objekAkunNasabah);
                    objGantiPIN.prosesTransaksi();
                    lanjutLagi();
                    break;
                case "6":
                    /**
                     * jika inputan user adalah 6 maka akan menampilkan pesan terima kasih dan
                     * menghentikan program atm
                     */
                    System.out.println("\nTerima kasih telah menggunakan ATM Bank WKG\n");
                    System.exit(0); // kode ini digunakan untuk menghentikan program
                default:
                    /**
                     * jika inputan user tidak sesuai dengan menu maka akan menampilkan pesan
                     * "Inputan tidak valid" dan perulangan akan diulangi lagi sampai user input yang benar
                     */
                    System.out.println("\nPilihan tidak valid!");
            }
        }
    }

    // Method menuPilihan pertama yang menerima objectAkunAdmin dan method ini dibuat khusus akunAdmin
    // Method ini menampilkan pesan informasi tentang akun admin yaitu nama akun admin dan nomor rekening admin
    public void menuPilihan(AkunAdmin objekAkunAdmin) {
        System.out.println("\n|====================================|");
        System.out.println("|~~Selamat Datang di Tampilan Admin~~|");
        System.out.println("|====================================|");
        System.out.println("  Nama         : " + objekAkunAdmin.getUsername());
        System.out.println("  No. Rekening : " + objekAkunAdmin.getNomorRekening());
        System.out.println("|====================================|");
    }

    // Method lanjutLagi digunakan untuk menanyakan apakah user
    // ingin melanjutkan transaksi atau tidak
    public void lanjutLagi() {
        /**
         * Perulangan while dengan kondisi boolean true dibuat supaya perulangan dilakukan terus menerus.
         * Alasan dibuat terus menerurs karena ketika suatu user melakukan input yang salah atau tidak cocok dengan kondisi
         * maka perulangan nya akan diulangi lagi sampai user input yang benar atau cocok dengan kondisi
         * perulangan baru berhenti karena terdapat keyword BREAK.
         */
        while (true) {
            // Menampilkan pesan untuk menanyakan apakah user ingin melanjutkan transaksi atau tidak
            System.out.print("\nApakah anda ingin melakukan transaksi lainnya (y/n)?: ");
            // Membuat object scanner untuk menerima inputan user
            Scanner scan = new Scanner(System.in);
            // Membuat variabel inputanUser bertipe data String untuk menyimpan inputan user
            // Menggunakan method toLowerCase untuk mengubah inputan user menjadi huruf kecil
            // Jadi walaupun user memasukkan huruf y atau n dalam huruf besar
            // inputan user akan tetap diubah menjadi huruf kecil
            String pilihan = scan.next().toLowerCase();

            // Membuat kondisi if untuk mengecek inputan user
            switch (pilihan) {
                case "y":
                    // Jika inputan user adalah y maka akan memanggil
                    // method menuPilihan() untuk menampilkan menu pilihan
                    menuPilihan((AkunNasabah) objekAkun);
                    break;
                case "n":
                    // Jika inputan user adalah n maka akan menampilkan pesan terima kasih
                    System.out.println("\nTerima kasih telah menggunakan ATM Bank WKG\n");
                    System.exit(0); // kode ini digunakan untuk menghentikan program
                default:
                    // Jika inputan user tidak sesuai dengan kondisi maka akan menampilkan pesan "Pilihan tidak valid"
                    System.out.println("\nPilihan tidak valid!");
            }
        }
    }
}
