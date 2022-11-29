import java.text.DecimalFormat;

public abstract class Transaksi implements FormatUang {
    DecimalFormat formatUangRupiah = new DecimalFormat("'Rp'###,##0.00");

    protected AkunNasabah objekAkunNasabah ;

    public Transaksi(AkunNasabah objekAkunNasabah) {
        this.objekAkunNasabah = objekAkunNasabah;
    }

    public String formatUang(int value) {
        return formatUangRupiah.format(value);
    }

    public abstract  void prosesTransaksi();

}
