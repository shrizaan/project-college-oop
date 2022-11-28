import java.util.Scanner;

public class Transfer extends Transaksi {
    private String nomorRekeningTujuan;
    private int jumlahTransfer;
    private int konfirmasiJumlahTransfer;

    public Transfer(AkunNasabah objekAkunNasabah) {
        super(objekAkunNasabah);
    }

    public void prosesTransaksi() {
        AkunNasabah akunNasabah = getObjAkunNasabah();
        Scanner input = new Scanner(System.in);

        System.out.print("\nMasukkan nomor rekening tujuan: ");
        nomorRekeningTujuan = input.nextLine();

        while (true) {
            System.out.print("Masukkan jumlah transfer: ");
            jumlahTransfer = input.nextInt();
            System.out.print("Konfirmasi jumlah transfer: ");
            konfirmasiJumlahTransfer = input.nextInt();

            if (jumlahTransfer == konfirmasiJumlahTransfer) {
                if (jumlahTransfer >= 100000) {
                    if (jumlahTransfer < akunNasabah.getSaldo()) {
                        akunNasabah.setSaldo(akunNasabah.getSaldo() - jumlahTransfer);

                        System.out.println("\nTransfer berhasil");
                        System.out.println("Nomor Rekening Tujuan: " + nomorRekeningTujuan);
                        System.out.println("Jumlah transfer: " + formatUang(jumlahTransfer));
                        System.out.println("Saldo anda saat ini adalah: " + formatUang(akunNasabah.getSaldo()));
                        break;
                    } else {
                        System.out.println("\nMaaf, saldo anda tidak mencukupi");
                        break;
                    }
                } else {
                    System.out.println("\nJumlah transfer minimal Rp100.000\n");
                }
            } else {
                System.out.println("\nJumlah transfer tidak sama\n");
            }
        }
    }
}
