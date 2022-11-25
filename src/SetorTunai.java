import java.util.Scanner;

public class SetorTunai extends Transaksi{
    private String jumlahSetoran;
    private String konfirmasiJumlahSetoran;
    private AkunNasabah objAkunNasabah;

    private String nomorRekeningTujuan;

    public SetorTunai(String nomorRekening, DatabaseAkun atmDatabase) {
        super(nomorRekening, atmDatabase);
    }

    public void setJumlahSetoran(String jumlahSetoran) {
        this.jumlahSetoran = jumlahSetoran;
    }

    public String getJumlahSetoran() {
        return jumlahSetoran;
    }

    @Override
    public void execute() {
        Scanner input = new Scanner(System.in);
        System.out.println("Pilih jenis setoran");
        System.out.println("1. Setor ke rekening sendiri");
        System.out.println("2. Setor ke rekening lain");
        String pilihan = input.nextLine();

        if (pilihan.equals("1")) {
            inputSetoran(input);
        } else if (pilihan.equals("2")) {
            System.out.println("Masukkan nomor rekening tujuan: ");
            nomorRekeningTujuan = input.nextLine();
            inputSetoran(input);
        } else {
            System.out.println("Pilihan tidak ada");
        }
    }

    private void inputSetoran(Scanner input) {
        System.out.println("Masukkan jumlah setoran: ");
        jumlahSetoran = input.nextLine();
        System.out.println("Konfirmasi jumlah setoran: ");
        konfirmasiJumlahSetoran = input.nextLine();
        if (jumlahSetoran.equals(konfirmasiJumlahSetoran)) {
            objAkunNasabah = getDatabaseAkun().getAkun(getNomorRekening());
            objAkunNasabah.setSaldo(objAkunNasabah.getSaldo() + Integer.parseInt(jumlahSetoran));
            System.out.println("Setoran berhasil");
            System.out.println("Saldo anda saat ini adalah: " + formatUang(objAkunNasabah.getSaldo()));
        } else {
            System.out.println("Jumlah setoran tidak sama");
        }
    }

}


