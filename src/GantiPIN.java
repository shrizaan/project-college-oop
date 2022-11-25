import java.util.Scanner;

public class GantiPIN extends Transaksi {
    private String pinLama;
    private String pinBaru;
    private String konfirmasiPinBaru;

    public GantiPIN(String nomorRekening, DatabaseAkun databaseAkun, String PIN) {
        super(nomorRekening, databaseAkun);
        this.pinLama = PIN;
    }

    public void execute() {
        AkunNasabah akunNasabah = getDatabaseAkun().getAkun(getNomorRekening());
        System.out.println("Masukkan PIN lama: ");
        Scanner input = new Scanner(System.in);
        pinLama = input.nextLine();

        if (pinLama.equals(akunNasabah.getPin())) {
            System.out.println("Masukkan PIN baru: ");
            pinBaru = input.nextLine();
            System.out.println("Konfirmasi PIN baru: ");
            konfirmasiPinBaru = input.nextLine();

            if (pinBaru.equals(konfirmasiPinBaru)) {
                akunNasabah.setPin(pinBaru);
                System.out.println("PIN berhasil diganti");
            } else {
                System.out.println("PIN baru tidak sama");
            }

        } else {
            System.out.println("PIN lama salah");
        }
        akunNasabah.setPin(pinBaru);
    }
}
