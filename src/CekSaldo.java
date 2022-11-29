public class CekSaldo extends Transaksi {
    private int saldoObjekNasabah;

    public CekSaldo(AkunNasabah objAkunNasabah) {
        super(objAkunNasabah);
    }

    public void setSaldoObjekNasabah(int saldoObjekNasabah) {
        this.saldoObjekNasabah = saldoObjekNasabah;
    }

    public int getSaldoObjekNasabah() {
        return saldoObjekNasabah;
    }

    public void prosesTransaksi() {
        setSaldoObjekNasabah(objekAkunNasabah.getSaldo());
        System.out.println("\nSaldo anda saat ini adalah: " + formatUang(getSaldoObjekNasabah()));
    }
}
