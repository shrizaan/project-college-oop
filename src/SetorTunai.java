public class SetorTunai extends Transaksi{
    private String jumlahSetoran;
    private String konfirmasiJumlahSetoran;

    public SetorTunai(String nomorRekening, DatabaseAkun atmDatabase) {
        super(nomorRekening, atmDatabase);
    }

    public void setJumlahSetoran(String jumlahSetoran) {
        this.jumlahSetoran = jumlahSetoran;
    }

    public String getJumlahSetoran() {
        return jumlahSetoran;
    }


}
