import java.util.Scanner;

public class Transfer extends Transaksi {
    private String nomorRekeningTujuan;
    private int jumlahTransfer;
    private int konfirmasiJumlahTransfer;

    public Transfer(AkunNasabah objekAkunNasabah) {
        super(objekAkunNasabah);
    }

    public void prosesTransaksi() {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan nomor rekening tujuan: ");
        nomorRekeningTujuan = input.nextLine();

        while (true) {
            System.out.println("Masukkan jumlah transfer: ");
            jumlahTransfer = input.nextInt();
            System.out.println("Konfirmasi jumlah transfer: ");
            konfirmasiJumlahTransfer = input.nextInt();
            if (jumlahTransfer == konfirmasiJumlahTransfer) {
                if (jumlahTransfer > getObjAkunNasabah().getSaldo()) {
                    System.out.println("Maaf, saldo anda tidak mencukupi");
                    break;
                } else {
                    getObjAkunNasabah().setSaldo(getObjAkunNasabah().getSaldo() - jumlahTransfer);
                    System.out.println("Transfer berhasil");
                    System.out.println("Nomor Rekening Tujuan: " + nomorRekeningTujuan);
                    System.out.println("Jumlah transfer: " + formatUang(jumlahTransfer));
                    System.out.println("Saldo anda saat ini adalah: " + formatUang(getObjAkunNasabah().getSaldo()));
                    break;
                }
            } else {
                System.out.println("Jumlah transfer tidak sama");
            }
        }
    }
}
