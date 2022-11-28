import java.util.Scanner;

public class GantiPIN extends Transaksi {
    private String pinLama;
    private String pinBaru;
    private String konfirmasiPinBaru;

    public GantiPIN(AkunNasabah objekAkunNasabah) {
        super(objekAkunNasabah);
    }

    public void prosesTransaksi() {
        AkunNasabah akunNasabah = getObjAkunNasabah();
        Scanner input = new Scanner(System.in);

        System.out.print("\nMasukkan PIN lama: ");
        pinLama = input.nextLine();

        if (pinLama.equals(akunNasabah.getPin())) {
            while (true) {
                System.out.print("Masukkan PIN baru: ");
                pinBaru = input.nextLine();
                System.out.print("Konfirmasi PIN baru: ");
                konfirmasiPinBaru = input.nextLine();

                if (pinBaru.equals(konfirmasiPinBaru)) {
                    akunNasabah.setPin(pinBaru);
                    System.out.println("\nPIN berhasil diganti");
                    break;
                } else {
                    System.out.println("\nPIN baru tidak sama\n");
                }
            }
        } else {
            System.out.println("\nPIN lama salah");
        }
    }
}
