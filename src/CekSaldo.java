public class CekSaldo extends Transaksi {
    AkunNasabah akunNasabah;

    public CekSaldo(String nomorRekening, DatabaseAkun databaseAkun) {
        super(nomorRekening, databaseAkun);
    }

    @Override
    public void prosesTransaksi() {
        this.akunNasabah = getDatabaseAkun().getAkun(getNomorRekening());
        System.out.println("\nSaldo anda saat ini adalah: " + formatUang(akunNasabah.getSaldo()));
    }
}
