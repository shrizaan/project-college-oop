public class GantiPIN extends Transaksi {
    private String pinLama;
    private String pinBaru;
    private String konfirmasiPinBaru;

    public GantiPIN(String nomorRekening, DatabaseAkun atmDatabase) {
        super(nomorRekening, atmDatabase);
    }

    @Override
    public void execute() {
        Akun userAccount = getDatabaseAkun().getAkun(getNomorRekening());
        userAccount.setPIN(pinBaru);
    }

    public void setPinLama(String pinLama) {
        this.pinLama = pinLama;
    }

    public void setPinBaru(String pinBaru) {
        this.pinBaru = pinBaru;
    }
}
