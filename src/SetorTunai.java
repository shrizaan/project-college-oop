import java.util.Scanner;

public class SetorTunai extends Transaksi{
    private String jumlahSetoran;
    private String konfirmasiJumlahSetoran;

    public SetorTunai(AkunNasabah objekAkunNasabah) {
        super(objekAkunNasabah);
    }

    public void prosesTransaksi() {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Masukkan jumlah setoran: ");
            jumlahSetoran = input.nextLine();
            System.out.println("Konfirmasi jumlah setoran: ");
            konfirmasiJumlahSetoran = input.nextLine();
            if (jumlahSetoran.equals(konfirmasiJumlahSetoran)) {
                getObjAkunNasabah().setSaldo(getObjAkunNasabah().getSaldo() + Integer.parseInt(jumlahSetoran));
                System.out.println("Setoran berhasil");
                System.out.println("Jumlah setoran: " + formatUang(Integer.parseInt(jumlahSetoran)));
                System.out.println("Saldo anda saat ini adalah: " + formatUang(getObjAkunNasabah().getSaldo()));
                break;
            } else {
                System.out.println("Jumlah setoran tidak sama");
                break;
            }
        }
    }
}


