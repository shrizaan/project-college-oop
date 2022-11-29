import java.util.ArrayList;

public class DatabaseAkun {
    private ArrayList<Akun> databaseAkun = new ArrayList<>(); // array bertipe Akun

    public DatabaseAkun() {
        Akun AkunNasabah1 = new AkunNasabah("Shahrizan", "12345", "11111", 10_000_000);
        Akun AkunNasabah2 = new AkunNasabah("Alif Putra Cira", "98765", "22222", 20_000_000);
        Akun AkunNasabah3 = new AkunNasabah("Raffi Firdaus", "19234", "33333", 30_000_000);
        Akun AkunAdmin4 = new AkunAdmin("Nanda Aulia Shofiah", "00000", "12022", true);
        Akun AkunAdmin5 = new AkunAdmin("Ishlah Putri Ariyani", "99999", "20045", true);

        databaseAkun.add(AkunNasabah1);
        databaseAkun.add(AkunNasabah2);
        databaseAkun.add(AkunNasabah3);
        databaseAkun.add(AkunAdmin4);
        databaseAkun.add(AkunAdmin5);
    }

    public Akun getAkun(String nomorRekening, String pin) {
        for (Akun akun : databaseAkun) {
            if (akun.validasiNomorRekening(nomorRekening) && akun.validasiPin(pin)) {
                return akun;
            }
        }
        return null;
    }
}
