import java.util.ArrayList;
import java.util.Iterator;

// BankDatabase.java
// Represents the bank account information database

public class DatabaseAkun {
    static ArrayList<Akun> databaseAkun = new ArrayList<>(); // array of Accounts

    public DatabaseAkun() {
        //The original array has been changed into an arraylist, this makes it easier to add/delete from the database
        Akun AkunNasabah1 = new AkunNasabah("Customer1", "12345", "11111", 1000, 1200);
        Akun AkunNasabah2 = new AkunNasabah("Customer2", "98765", "22222", 200, 200);
        Akun AkunNasabah3 = new AkunNasabah("Customer3", "19234", "33333", 200, 200);
        Akun AkunAdmin4 = new AkunAdmin("Manager1", "00000", true);
        databaseAkun.add(AkunNasabah1);
        databaseAkun.add(AkunNasabah2);
        databaseAkun.add(AkunNasabah3);
        databaseAkun.add(AkunAdmin4);
    }

    // retrieve account object containing specified account number

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

    private Akun getPinAkun(String PIN) {
        // loop through accounts searching for matching account number
        for (Akun akun : databaseAkun) {
            // return current account if match found
            if (akun.getPin() == PIN)
                return akun;
        } // end for

        return null; // if no matching account was found, return null
    } //

    // determine whether user-specified account number and PIN match
    // those of an account in the database
    public boolean validasiPIN(String userPIN) {
        // attempt to retrieve the account with the account number
        Akun userAccount = getPinAkun(userPIN);

        // if account exists, return result of Account method validatePIN
        if (userAccount != null)
            return userAccount.validasiPIN(userPIN);
        else
            return false; // account number not found, so return false
    } // end method authenticateUser

    // return available balance of Account with specified account number
    public double getAvailableBalance(String userAccountNumber) {
        return  getAkun(userAccountNumber).getSaldoYangTersedia();
    } // end method getAvailableBalance

    // return total balance of Account with specified account number
    public double getTotalBalance(String userAccountNumber) {
        return getAkun(userAccountNumber).getTotalSaldo();
    } // end method getTotalBalance

    // credit an amount to Account with specified account number
    public void credit(String userAccountNumber, int amount) {
        getAkun(userAccountNumber).credit(amount);
    } // end method credit

    // debit an amount from Account with specified account number
    public void debit(String userAccountNumber, int amount) {
        AkunNasabah obj = (AkunNasabah) getAkun(userAccountNumber);
        obj.debit(amount);
    } // end method debit

//    public int getadmin(int userAccountNumber) {
//        return getAkunpin(userAccountNumber). ();
//    }

    public static Iterator createIterator() {
        return new AkunIterator(databaseAkun);
    }

    public String getaccpin(String PIN) {
        for (Akun currentAccount : databaseAkun) {
            // return current account if match found
            AkunNasabah akunNasabah = (AkunNasabah) currentAccount;
            if (akunNasabah.getPin().equals(PIN))
                return akunNasabah.getNomorRekening();
            else
                return "1";
        } // end for
        return PIN;
    }

    public static void Adduser() {
//        String name = Screen.Inputfield1.getText();
//        String accountnumber = Integer.parseInt(Screen.Inputfield2.getText());
//        String pin = Integer.parseInt(Screen.Inputfield4.getText());
//        int balance = Integer.parseInt(Screen.Inputfield3.getText());

//        Akun newaccount = new AkunNasabah(name, accountnumber, pin, balance, balance);
//        databaseAkun.add(newaccount);
    }

    public static void Deleteuser(int position) {
        databaseAkun.remove(position);

    }
}
