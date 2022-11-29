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
    //   attribute objekAkun bertipe Akun yang digunakan
    //   untuk menyimpan object AkunNasabah atau AkunAdmin yang sedang login sekarang
    private Akun objekAkun;

    // Method login digunakan untuk melakukan login ke aplikasi atm
    public void login() {
        /**
         * Perulangan while dengan kondisi boolean true dibuat supaya perulangan dilakukan terus menerus.
         * Alasan dibuat terus menerurs karena ketika suatu user
         * melakukan input yang salah atau tidak cocok dengan kondisi
         * maka perulangan nya akan diulangi lagi sampai user input yang benar atau cocok dengan kondisi
         * perulangan baru berhenti karena terdapat keyword BREAK.
         */
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Masukkan nomor rekening: "); // meminta inputan nomorRekening ke user
            String nomorRekening = input.next(); // simpan inputan user ke variabel nomoRekening bertipe string
            System.out.print("Masukkkan nomor pin: "); // meminta inputan nomor pin ke user
            String pin = input.next(); // simpanan inputan user ke variabel pin bertipe string

            DatabaseAkun databaseAkun = new DatabaseAkun();

            objekAkun = databaseAkun.getAkun(nomorRekening, pin);

            if (objekAkun != null && objekAkun instanceof AkunNasabah) {
                menuPilihan((AkunNasabah) objekAkun);
                break;
            } else if (objekAkun != null && objekAkun instanceof AkunAdmin) {
                menuPilihan((AkunAdmin) objekAkun);
                break;
            }
            else {
                System.out.println("\nNomor Rekening atau PIN tidak ada di database!\n");
            }
        }
    }

    public void menuPilihan(AkunNasabah objekAkunNasabah) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("\n|====================================|");
            System.out.println("  Nama         : " + objekAkunNasabah.username);
            System.out.println("  No. Rekening : " + objekAkunNasabah.nomorRekening);
            System.out.println("|====================================|");

            System.out.println("\t1. Cek Saldo");
            System.out.println("\t2. Tarik Tunai");
            System.out.println("\t3. Setor Tunai");
            System.out.println("\t4. Transfer");
            System.out.println("\t5. Ganti PIN");
            System.out.println("\t6. Keluar");
            System.out.print("Pilih transaksi yang ingin dilakukan: ");
            String transaksi = scan.next();

            switch (transaksi) {
                case "1":
                    CekSaldo objCekSaldo = new CekSaldo(objekAkunNasabah);
                    objCekSaldo.prosesTransaksi();
                    lanjutLagi();
                    break;
                case "2":
                    TarikTunai objTarikTunai = new TarikTunai(objekAkunNasabah);
                    objTarikTunai.prosesTransaksi();
                    lanjutLagi();
                    break;
                case "3":
                    SetorTunai objSetorTunai = new SetorTunai(objekAkunNasabah);
                    objSetorTunai.prosesTransaksi();
                    lanjutLagi();
                    break;
                case "4":
                    Transfer objTransfer = new Transfer(objekAkunNasabah);
                    objTransfer.prosesTransaksi();
                    lanjutLagi();
                    break;
                case "5":
                    GantiPIN objGantiPIN = new GantiPIN(objekAkunNasabah);
                    objGantiPIN.prosesTransaksi();
                    lanjutLagi();
                    break;
                case "6":
                    System.out.println("\nTerima kasih telah menggunakan ATM Bank WKG\n");
                    System.exit(0); // kode ini digunakan untuk menghentikan program
                default:
                    System.out.println("\nPilihan tidak valid!");
            }
        }
    }

    public void menuPilihan(AkunAdmin objekAkunAdmin) {
        System.out.println("\n|====================================|");
        System.out.println("|~~Selamat Datang di Tampilan Admin~~|");
        System.out.println("|====================================|");
        System.out.println("  Nama         : " + objekAkunAdmin.username);
        System.out.println("  No. Rekening : " + objekAkunAdmin.nomorRekening);
        System.out.println("|====================================|");
    }

    public void lanjutLagi() {
        while (true) {
            System.out.print("\nApakah anda ingin melakukan transaksi lainnya (y/n)?: ");
            Scanner scan = new Scanner(System.in);
            String pilihan = scan.next().toLowerCase();

            switch (pilihan) {
                case "y":
                    menuPilihan((AkunNasabah) objekAkun);
                    break;
                case "n":
                    System.out.println("\nTerima kasih telah menggunakan ATM Bank WKG\n");
                    System.exit(0);
                default:
                    System.out.println("\nPilihan tidak valid!");
            }
        }
    }
}
