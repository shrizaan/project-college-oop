import java.text.DecimalFormat;

public abstract class  Transaksi implements FormatUang {
    DecimalFormat moneyFormat = new DecimalFormat("'Rp'###,##0.00");

    private String nomorRekening;
    private String pin;
    private DatabaseAkun databaseAkun;

    public Transaksi(String nomorRekening, DatabaseAkun databaseAkun) {
        this.nomorRekening = nomorRekening;
        this.databaseAkun = databaseAkun;
    }

    public String formatUang(int value) {
        return moneyFormat.format(value);
    }


    abstract public void execute();

}
