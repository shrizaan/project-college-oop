import java.util.ArrayList;

public class DatabaseAkun {
//    alasan kami menggunakan tipe data arraylist karena tipe data arraylist lebih mudah untuk di manipulasi seperti menambahkan data tanpa perlu mengkhawatirkan ukuran array nya.
//    selain itu alasan kami tidak menjadi kannya sebagai attribute karena karena kami ingin variabel ini tidak dapat diakses oleh class lain.
    private static ArrayList<Akun> databaseAkun = new ArrayList<>(); // array of Accounts

    public DatabaseAkun() {
        //membuat akun nasabah dan admin
        Akun AkunNasabah1 = new AkunNasabah("Shahrizan", "12345", "11111", 10_000_000);
        Akun AkunNasabah2 = new AkunNasabah("Alif Putra Cira", "98765", "22222", 20_000_000);
        Akun AkunNasabah3 = new AkunNasabah("Raffi Firdaus", "19234", "33333", 30_000_000 );
        Akun AkunAdmin4 = new AkunAdmin("Nanda Aulia Shofiah", "00000", "12022", true);
        Akun AkunAdmin5 = new AkunAdmin("Ishlah Putri Ariyani", "99999", "20045", true);
        databaseAkun.add(AkunNasabah1);
        databaseAkun.add(AkunNasabah2);
        databaseAkun.add(AkunNasabah3);
        databaseAkun.add(AkunAdmin4);
        databaseAkun.add(AkunAdmin5);
    }

    public AkunNasabah getAkun(String nomorRekening, String pin) {
        for (Akun akun : databaseAkun) {
            if (akun instanceof AkunNasabah) {
                AkunNasabah objAkunNasabah = (AkunNasabah) akun;
                if (objAkunNasabah.validasiNomorRekening(nomorRekening) && objAkunNasabah.validasiPin(pin)) {
                    return objAkunNasabah;
                }
            }
        }
        return null;
    }
}
