import java.util.Scanner;

public class TarikTunai extends Transaksi {
    private String jumlahPenarikan;
    public TarikTunai(String nomorRekening, DatabaseAkun atmDatabase) {
        super(nomorRekening, atmDatabase);
    }

    // debits an amount from the account
    public void debit(double amount)
    {

    } // end method debit

    @Override
    public void execute() {
        Scanner input = new Scanner(System.in);
        AkunNasabah akunNasabah = getDatabaseAkun().getAkun(getNomorRekening());

        System.out.println("\n========================");
        System.out.println("Saldo anda saat ini adalah: " + formatUang(akunNasabah.getSaldo()));
        System.out.print("Masukkan jumlah penarikan: ");
        jumlahPenarikan = input.nextLine();

        int jumlahPenarikanInt = Integer.parseInt(jumlahPenarikan);
        if (jumlahPenarikanInt > akunNasabah.getSaldo()) {
            System.out.println("Maaf, saldo anda tidak mencukupi");
        } else {
            akunNasabah.setSaldo(akunNasabah.getSaldo() - jumlahPenarikanInt);
            System.out.println("\nPenarikan berhasil");
            System.out.println("Saldo anda saat ini adalah: " + formatUang(akunNasabah.getSaldo()));
        }
    }
}
