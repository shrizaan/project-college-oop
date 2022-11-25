import java.text.DecimalFormat;

public abstract class  Transaksi implements FormatUang {
    DecimalFormat moneyFormat = new DecimalFormat("'Rp'###,##0.00");

    private AkunNasabah objAkunNasabah ;

    public Transaksi(AkunNasabah objAkunNasabah) {
        this.objAkunNasabah = objAkunNasabah;
    }

    public AkunNasabah getObjAkunNasabah() {
        return objAkunNasabah;
    }

    public String formatUang(int value) {
        return moneyFormat.format(value);
    }

    abstract public void prosesTransaksi();

}
