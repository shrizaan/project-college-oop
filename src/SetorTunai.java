import java.util.Scanner;

public class SetorTunai extends Transaksi {
    private int jumlahSetoran;
    private int konfirmasiJumlahSetoran;

    public SetorTunai(AkunNasabah objekAkunNasabah) {
        super(objekAkunNasabah);
    }

    public void prosesTransaksi() {
        AkunNasabah akunNasabah = getObjAkunNasabah();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nSaldo anda saat ini adalah: " + formatUang(akunNasabah.getSaldo()));
            System.out.print("Masukkan jumlah setoran: ");
            jumlahSetoran = input.nextInt();
            System.out.print("Konfirmasi jumlah setoran: ");
            konfirmasiJumlahSetoran = input.nextInt();

            if (jumlahSetoran == konfirmasiJumlahSetoran) {
                if (jumlahSetoran >= 100000) {
                    akunNasabah.setSaldo(akunNasabah.getSaldo() + jumlahSetoran);
                    System.out.println("Setoran berhasil");
                    System.out.println("Jumlah setoran: " + formatUang(jumlahSetoran));
                    System.out.println("Saldo anda saat ini adalah: " + formatUang(akunNasabah.getSaldo()));
                    break;
                } else {
                    System.out.println("\nJumlah setoran minimal Rp100.000");
                }
            } else {
                System.out.println("\nJumlah setoran tidak sama");
            }
        }
    }
}


