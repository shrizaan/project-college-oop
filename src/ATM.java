import javax.xml.crypto.Data;
import java.util.Scanner;

public class ATM extends DatabaseAkun implements LanjutLagi, Keluar {
    private boolean lanjutLagi;

    private  AkunNasabah objekAkunNasabah;

    public void login() {
        Scanner input = new Scanner(System.in);
        boolean transaksiSelesai;
        while (true) {
            System.out.println("Masukkan nomor kartu: ");
            String nomorRekening = input.next();
            System.out.println("Masukkkan nomor pin: ");
            String pin = input.next();

            DatabaseAkun databaseAkun = new DatabaseAkun();
            objekAkunNasabah = databaseAkun.getAkun(nomorRekening, pin);
            if (objekAkunNasabah != null) {
                menuPilihan(objekAkunNasabah);
            } else {
                System.out.println("Nomor Rekening atau PIN tidak ada di database!");
            }
        }
    }

    public void menuPilihan(AkunNasabah objekAkunNasabah) {
        Scanner scan = new Scanner(System.in);
        boolean lanjut = true;

        do {
            System.out.println("===================================");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Tarik Tunai");
            System.out.println("3. Setor Tunai");
            System.out.println("4. Transfer");
            System.out.println("5. Ganti PIN");
            System.out.println("6. Keluar");
            System.out.print("Pilih transaksi yang ingin dilakukan: ");
            String transaksi = scan.next();

            switch (transaksi) {
                case "1":
                    CekSaldo objCekSaldo = new CekSaldo(objekAkunNasabah);
                    objCekSaldo.prosesTransaksi();
                    lanjut = lanjutLagi();
                    break;
                case "2":
                    TarikTunai objTarikTunai = new TarikTunai(objekAkunNasabah);
                    objTarikTunai.prosesTransaksi();
                    lanjut = lanjutLagi();
                    break;
                case "3":
                    SetorTunai objSetorTunai = new SetorTunai(objekAkunNasabah);
                    objSetorTunai.prosesTransaksi();
                    lanjut = lanjutLagi();
                    break;
                case "4":
                    Transfer objTransfer = new Transfer(objekAkunNasabah);
                    objTransfer.prosesTransaksi();
                    lanjut = lanjutLagi();
                    break;
                case "5":
                    GantiPIN objGantiPIN = new GantiPIN(objekAkunNasabah);
                    objGantiPIN.prosesTransaksi();
                    lanjut = lanjutLagi();
                    break;
                case "6":
                    keluar();
                    lanjut = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (lanjut);
    }

    public void keluar() {
        System.out.println("\nTerima kasih telah menggunakan ATM Bank WGO\n");
        System.exit(0);
    }

    public boolean lanjutLagi() {
        boolean berhasil = false;

        do {
            System.out.println("\nApakah anda ingin melakukan transaksi lainnya? (y/n)");
            Scanner scan = new Scanner(System.in);
            String pilihan = scan.next();

            switch (pilihan) {
                case "y":
                    lanjutLagi = true;
                    berhasil = false;
                    break;
                case "n":
                    lanjutLagi = false;
                    berhasil = false;
                    keluar();
                    break;
                default:
                    System.out.println("\nPilihan tidak valid!");
                    berhasil = true;
            }
        } while (berhasil);
        return lanjutLagi;
    }
}
