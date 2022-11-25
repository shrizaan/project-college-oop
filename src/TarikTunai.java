import java.util.Scanner;

public class TarikTunai extends Transaksi {
    private int jumlahPenarikan;
    private int konfirmasiJumlahPenarikan;
    public TarikTunai(AkunNasabah objekAkunNasabah) {
        super(objekAkunNasabah);
    }

    public void prosesTransaksi() {
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("\nSaldo anda saat ini adalah: " + formatUang(getObjAkunNasabah().getSaldo()));
            System.out.print("Masukkan jumlah penarikan: ");
            jumlahPenarikan = input.nextInt();
            System.out.print("Konfirmasi jumlah penarikan: ");
            konfirmasiJumlahPenarikan = input.nextInt();

            if (jumlahPenarikan == konfirmasiJumlahPenarikan) {
                if (jumlahPenarikan >= 100_000){
                    if (jumlahPenarikan > getObjAkunNasabah().getSaldo()) {
                        System.out.println("\nMaaf, saldo anda tidak mencukupi");
                        break;
                    } else {
                        getObjAkunNasabah().setSaldo(getObjAkunNasabah().getSaldo() - jumlahPenarikan);
                        System.out.println("\nPenarikan berhasil");
                        System.out.println("Jumlah penarikan: " + formatUang(jumlahPenarikan));
                        System.out.println("Saldo anda saat ini adalah: " + formatUang(getObjAkunNasabah().getSaldo()));
                        break;
                    }
                } else {
                    System.out.println("\nJumlah penarikan minimal Rp100.000");
                }
            } else {
                System.out.println("\nJumlah penarikan tidak sama");
            }
        }
    }
}
