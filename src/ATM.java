import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nSelamat datang di ATM Bank WGO!\n");
        System.out.println("==================================");
        System.out.println("Masukkan nomor kartu: ");
        String nomorRekening = scan.next();
        System.out.println("Masukkan PIN: ");
        String PIN = scan.next();

        System.out.println("\n===================================\n");
        System.out.println("1. Cek Saldo");
        System.out.println("2. Tarik Tunai");
        System.out.println("3. Setor Tunai");
        System.out.println("4. Transfer");
        System.out.println("5. Ganti PIN");
        System.out.println("6. Keluar");
        System.out.print("Pilih transaksi yang ingin dilakukan: ");
        String transaksi = scan.next();

        boolean berhasil;
        do {
            berhasil = false;
            switch (transaksi) {
                case "1":
                    CekSaldo objCekSaldo = new CekSaldo(nomorRekening, new DatabaseAkun());
                    objCekSaldo.execute();
                    berhasil = false;
                    break;
                case "2":
                    TarikTunai objTarikTunai = new TarikTunai(nomorRekening, new DatabaseAkun());
                    berhasil = false;
                    break;
                case "3":
                    SetorTunai objSetorTunai = new SetorTunai(nomorRekening, new DatabaseAkun());
                    berhasil = false;
                    break;
                case "4":
                    Transfer objTransfer = new Transfer(nomorRekening, new DatabaseAkun());
                    berhasil = false;
                    break;
                case "5":
                    GantiPIN objGantiPIN = new GantiPIN(nomorRekening, new DatabaseAkun(), PIN);
                    berhasil = false;
                    break;
                case "6":
                    System.out.println("Terima kasih telah mengguanakn ATM Bank WGO");
                    berhasil = false;
                    break;
                default:
                    berhasil = true;
            }
        } while (berhasil);
    }
}

