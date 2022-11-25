import java.util.Scanner;

public class TarikTunai extends Transaksi {
    private int jumlahPenarikan;
    public TarikTunai(AkunNasabah objekAkunNasabah) {
        super(objekAkunNasabah);
    }

    public void prosesTransaksi() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n========================");
        System.out.println("Saldo anda saat ini adalah: " + formatUang(getObjAkunNasabah().getSaldo()));
        System.out.print("Masukkan jumlah penarikan: ");
        jumlahPenarikan = input.nextInt();
        if (jumlahPenarikan >= 100_000){
            if (jumlahPenarikan > getObjAkunNasabah().getSaldo()) {
                System.out.println("Maaf, saldo anda tidak mencukupi");
            } else {
                getObjAkunNasabah().setSaldo(getObjAkunNasabah().getSaldo() - jumlahPenarikan);
                System.out.println("\nPenarikan berhasil");
                System.out.println("Jumlah penarikan: " + formatUang(jumlahPenarikan));
                System.out.println("Saldo anda saat ini adalah: " + formatUang(jumlahPenarikan));
            }
        } else {
            System.out.println("Jumlah penarikan minimal Rp100.000");
        }
    }
}
