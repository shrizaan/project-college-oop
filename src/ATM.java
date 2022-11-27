import java.util.Scanner;

public class ATM extends DatabaseAkun {
    private  AkunNasabah objekAkunNasabah;

    public void login() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Masukkan nomor rekening: ");
            String nomorRekening = input.next();
            System.out.print("Masukkkan nomor pin: ");
            String pin = input.next();

            DatabaseAkun databaseAkun = new DatabaseAkun();
            objekAkunNasabah = databaseAkun.getAkun(nomorRekening, pin);
            if (objekAkunNasabah != null) {
                menuPilihan(objekAkunNasabah);
                break;
            } else {
                System.out.println("\nNomor Rekening atau PIN tidak ada di database!\n");
            }
        }
    }

    public void menuPilihan(AkunNasabah objekAkunNasabah) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\n|====================================|");
            System.out.println("  Nama         : " + objekAkunNasabah.getUsername());
            System.out.println("  No. Rekening : " + objekAkunNasabah.getNomorRekening());
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
                    System.exit(0);
                default:
                    System.out.println("\nPilihan tidak valid!\n");
            }
        }
    }


    public void lanjutLagi() {
        while (true) {
            System.out.print("\nApakah anda ingin melakukan transaksi lainnya (y/n)?: ");
            Scanner scan = new Scanner(System.in);
            String pilihan = scan.next().toLowerCase();

            switch (pilihan) {
                case "y":
                    menuPilihan(objekAkunNasabah);
                case "n":
                    System.out.println("\nTerima kasih telah menggunakan ATM Bank WKG\n");
                    System.exit(0);
                default:
                    System.out.println("\nPilihan tidak valid!");
            }
        }
    }
}
