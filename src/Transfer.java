public class Transfer extends Transaksi {
    private String nomorRekeningTujuan;
    private String jumlahTransfer;
    private String konfirmasiJumlahTransfer;

    public Transfer(String nomorRekening, DatabaseAkun databaseAkun) {
        super(nomorRekening, databaseAkun);
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

    @Override
    public void prosesTransaksi() {
        AkunNasabah userAccount = getDatabaseAkun().getAkun(getNomorRekening());
        AkunNasabah tujuanAccount = getDatabaseAkun().getAkun(getNomorRekeningTujuan());

        if (tujuanAccount != null) {
            if (userAccount.getSaldo() >= Integer.parseInt(getJumlahTransfer())) {
                if (getJumlahTransfer().equals(getKonfirmasiJumlahTransfer())) {
                    userAccount.setSaldo(userAccount.getSaldo() - Integer.parseInt(getJumlahTransfer()));
                    tujuanAccount.setSaldo(tujuanAccount.getSaldo() + Integer.parseInt(getJumlahTransfer()));
                    System.out.println("Transfer berhasil");
                } else {
                    System.out.println("Jumlah transfer tidak sama");
                }
            } else {
                System.out.println("Saldo anda tidak mencukupi");
            }
        } else {
            System.out.println("Nomor rekening tujuan tidak ditemukan");
        }
    }

    private String getKonfirmasiJumlahTransfer() {
        return konfirmasiJumlahTransfer;
    }
}
