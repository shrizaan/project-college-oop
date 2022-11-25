import java.util.Scanner;

public class ATM extends DatabaseAkun implements  LanjutLagi, Keluar {
    private boolean lanjutLagi;

    private Akun objAkun;

    public static void login() {
        Scanner scan = new Scanner(System.in);
        boolean transaksiSelesai;
        do {
            System.out.print("Masukkan nomor kartu: ");
            String nomorRekening = scan.next();
            System.out.print("Masukkan PIN: ");
            String pin = scan.next();

            DatabaseAkun databaseAkun = new DatabaseAkun();
            try {
                AkunNasabah akunNasabah = databaseAkun.getAkun(nomorRekening);
                if (akunNasabah.validasiPin(pin) && akunNasabah.validasiNomorRekening(nomorRekening)) {
                    return true;
                } else {
                    return false;
                }
            } catch (NullPointerException e) {
                return false;
            }

            if (validasiAkunNasabah(nomorRekening, pin)) {
                menuPilihan(nomorRekening, pin);
                transaksiSelesai = true;
            } else {
                System.out.println("Nomor rekening atau PIN salah");
                transaksiSelesai = false;
            }

        } while (!transaksiSelesai);
    }

    public boolean validasiAkunNasabah(String nomorRekening, String pin) {

    }

    public void menuPilihan(String nomorRekening, String pin) {
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
                    CekSaldo objCekSaldo = new CekSaldo(nomorRekening, new DatabaseAkun());
                    objCekSaldo.prosesTransaksi();
                    lanjut = lanjutLagi();
                    break;
                case "2":
                    TarikTunai objTarikTunai = new TarikTunai(nomorRekening, new DatabaseAkun());
                    objTarikTunai.prosesTransaksi();
                    lanjut = lanjutLagi();
                    break;
                case "3":
                    SetorTunai objSetorTunai = new SetorTunai(nomorRekening, new DatabaseAkun());
                    objSetorTunai.prosesTransaksi();
                    lanjut = lanjutLagi();
                    break;
                case "4":
                    Transfer objTransfer = new Transfer(nomorRekening, new DatabaseAkun());
                    objTransfer.prosesTransaksi();
                    lanjut = lanjutLagi();
                    break;
                case "5":
                    GantiPIN objGantiPIN = new GantiPIN(nomorRekening, new DatabaseAkun(), pin);
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

    public  boolean lanjutLagi() {
        boolean berhasil = false;

        do {
            System.out.println("\nApakah anda ingin melakukan transaksi lainnya? (y/n)");
            Scanner scan = new Scanner(System.in);
            String pilihan = scan.next();

            switch(pilihan) {
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
