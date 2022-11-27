import java.util.ArrayList;

public class DatabaseAkun {
    // alasan kami menggunakan tipe data arraylist karena tipe data arraylist lebih mudah untuk
    // di manipulasi seperti menambahkan data tanpa perlu mengkhawatirkan ukuran array nya.
    // selain itu alasan kami tidak menjadi kannya sebagai attribute
    // karena kami ingin variabel ini tidak dapat diakses oleh class lain.
    private ArrayList<Akun> databaseAkun = new ArrayList<>(); // array bertipe Akun

    public DatabaseAkun() {
        // membuat akun nasabah dan admin
        Akun AkunNasabah1 = new AkunNasabah("Shahrizan", "12345", "11111", 10_000_000);
        Akun AkunNasabah2 = new AkunNasabah("Alif Putra Cira", "98765", "22222", 20_000_000);
        Akun AkunNasabah3 = new AkunNasabah("Raffi Firdaus", "19234", "33333", 30_000_000);
        Akun AkunAdmin4 = new AkunAdmin("Nanda Aulia Shofiah", "00000", "12022", true);
        Akun AkunAdmin5 = new AkunAdmin("Ishlah Putri Ariyani", "99999", "20045", true);
        // menambahkan objek AkunNasabah dan AkunAdmin ke array databaseAkun menggunakan method khusus arraylist
        // yaitu add
        databaseAkun.add(AkunNasabah1);
        databaseAkun.add(AkunNasabah2);
        databaseAkun.add(AkunNasabah3);
        databaseAkun.add(AkunAdmin4);
        databaseAkun.add(AkunAdmin5);
    }

    public Akun getAkun(String nomorRekening, String pin) {
        // melakukan perulangan for each yang mana setiap data pada attribute databaseAkun
        // akan dimasukkan ke variabel akun bertipe Akun
        // dan akan melakukan perulangan dari indeks 0 sampai paling akhir
        for (Akun akun : databaseAkun) {
            // melakukan pengecekan pada setiap objek Akun yang tersimpan di arraylist databaseAkun
            // jika nilai argument nomorRekening dan pin cocok dengan nilai yang ada di attribute akun
            // maka kembalikan objek akun tersebut
            if (akun.validasiNomorRekening(nomorRekening) && akun.validasiPin(pin)) {
                return akun;
            }
        }
        // jika nilai argument nya tidak cocok dengan nilai yang ada di attribute objek akun
        // maka kembalikan null
        return null;
    }
}
