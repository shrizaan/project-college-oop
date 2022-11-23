public class CekSaldo extends Transaksi {

    public CekSaldo(String nomorRekening, DatabaseAkun atmDatabase) {
        super(nomorRekening, atmDatabase);
    }

    @Override
    public void execute() {
        AkunNasabah userAccount = getDatabaseAkun().getAkun(getNomorRekening());
        System.out.println("Saldo anda saat ini adalah: " + userAccount.getSaldo());
    }
}
