import java.util.Scanner;

public class GantiPIN extends Transaksi {
    private String pinLama;
    private String pinBaru;
    private String konfirmasiPinBaru;

    public GantiPIN(AkunNasabah objekAkunNasabah) {
        super(objekAkunNasabah);
    }

    public void prosesTransaksi() {
        System.out.println("Masukkan PIN lama: ");
        Scanner input = new Scanner(System.in);
        pinLama = input.nextLine();

        if (pinLama.equals(getObjAkunNasabah().getPin())) {
            while (true) {
                System.out.println("Masukkan PIN baru: ");
                pinBaru = input.nextLine();
                System.out.println("Konfirmasi PIN baru: ");
                konfirmasiPinBaru = input.nextLine();
                if (pinBaru.equals(konfirmasiPinBaru)) {
                    getObjAkunNasabah().setPin(pinBaru);
                    System.out.println("PIN berhasil diganti");
                    break;
                } else {
                    System.out.println("PIN baru tidak sama");
                }
            }
        } else {
            System.out.println("PIN lama salah");
        }
    }
}
