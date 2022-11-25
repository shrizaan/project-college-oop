import java.text.DecimalFormat;

public abstract class Transaksi implements FormatUang {
    DecimalFormat moneyFormat = new DecimalFormat("'Rp'###,##0.00");

    private AkunNasabah objekAkunNasabah ;

    public Transaksi(AkunNasabah objekAkunNasabah) {
        this.objekAkunNasabah = objekAkunNasabah;
    }

    public AkunNasabah getObjAkunNasabah() {
        return objekAkunNasabah;
    }

    public String formatUang(int value) {
        return moneyFormat.format(value);
    }

    abstract public void prosesTransaksi();

}
