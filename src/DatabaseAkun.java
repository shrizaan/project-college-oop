import java.util.ArrayList;
import java.util.Iterator;

// BankDatabase.java
// Represents the bank account information database

public class DatabaseAkun {
    static ArrayList<Akun> databaseAkun = new ArrayList<>(); // array of Accounts

    public DatabaseAkun() {
        //The original array has been changed into an arraylist, this makes it easier to add/delete from the database
        Akun AkunNasabah1 = new AkunNasabah("Shahrizan", "12345", "11111", 10_000_000);
        Akun AkunNasabah2 = new AkunNasabah("Alif Putra Cira", "98765", "22222", 20_000_000);
        Akun AkunNasabah3 = new AkunNasabah("Raffi Firdaus", "19234", "33333", 30_000_000 );
        Akun AkunAdmin4 = new AkunAdmin("Nanda Aulia Shofiah", "00000", true);
        Akun AkunAdmin5 = new AkunAdmin("Ishlah Putri Ariyani", "99999", true);
        databaseAkun.add(AkunNasabah1);
        databaseAkun.add(AkunNasabah2);
        databaseAkun.add(AkunNasabah3);
        databaseAkun.add(AkunAdmin4);
        databaseAkun.add(AkunAdmin5);
    }

    public AkunNasabah getAkun(String accountnumber) {
        // loop through accounts searching for matching account number
        for (Akun akun : databaseAkun) {
            // jika akun merupakan AkunNasabah, return akun
            if (akun instanceof AkunNasabah) {
                AkunNasabah objAkunNasabah = (AkunNasabah) akun;
                // return current account if match found
                if (objAkunNasabah.getNomorRekening().equals(accountnumber)) {
                    return objAkunNasabah;
                }
            }

        } // end for
        return null; // if no matching account was found, return null
    } // end method getAkun
}
