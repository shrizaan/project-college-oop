public class Transfer extends Transaksi {
    private String nomorRekeningTujuan;
    private String jumlahTransfer;
    private String konfirmasiJumlahTransfer;

    public Transfer(String nomorRekening, DatabaseAkun atmDatabase) {
        super(nomorRekening, atmDatabase);
    }

    public void setNomorRekeningTujuan(String nomorRekeningTujuan) {
        this.nomorRekeningTujuan = nomorRekeningTujuan;
    }

    public void setJumlahTransfer(String jumlahTransfer) {
        this.jumlahTransfer = jumlahTransfer;
    }

    public void setKonfirmasiJumlahTransfer(String konfirmasiJumlahTransfer) {
        this.konfirmasiJumlahTransfer = konfirmasiJumlahTransfer;
    }

    public String getNomorRekeningTujuan() {
        return nomorRekeningTujuan;
    }

    public String getJumlahTransfer() {
        return jumlahTransfer;
    }
}
