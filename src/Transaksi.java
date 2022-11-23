import javax.xml.crypto.Data;
import java.text.DecimalFormat;

public abstract class  Transaksi implements Utilitas {
    DecimalFormat moneyFormat = new DecimalFormat("'Rp'###,##0.00");

    private String nomorRekening;

    private DatabaseAkun databaseAkun;

    public Transaksi(String nomorRekening, DatabaseAkun atmDatabase) {
        this.nomorRekening = nomorRekening;
        this.databaseAkun = atmDatabase;
    }
    public String formatUang(String value) {
        return moneyFormat.format(value);
    }

    public String getNomorRekening() {
        return nomorRekening;
    }

    public DatabaseAkun getDatabaseAkun() {
        return databaseAkun;
    }

    abstract public void execute();
}
