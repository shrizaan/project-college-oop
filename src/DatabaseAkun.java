import java.util.ArrayList;
import java.util.Iterator;

// BankDatabase.java
// Represents the bank account information database

public class DatabaseAkun {
    static ArrayList<Akun> databaseAkun = new ArrayList<>(); // array of Accounts

    public DatabaseAkun() {
        //The original array has been changed into an arraylist, this makes it easier to add/delete from the database
        Akun AkunNasabah1 = new AkunNasabah("Customer1", 12345, "11111", 1000, 1200);
        Akun AkunNasabah2 = new AkunNasabah("Customer2", 98765, "22222", 200, 200);
        Akun AkunNasabah3 = new AkunNasabah("Customer3", 19234, "33333", 200, 200);
        Akun AkunAdmin4 = new AkunAdmin("Manager1", "00000",  true);
        databaseAkun.add(AkunNasabah1);
        databaseAkun.add(AkunNasabah2);
        databaseAkun.add(AkunNasabah3);
        databaseAkun.add(AkunAdmin4);
    }

    // retrieve account object containing specified account number
    public Akun getAccount(String accountnumber, String pin) {
        // loop through accounts searching for matching account number
        for (Akun akun : databaseAkun) {
            // jika akun merupakan AkunNasabah, return akun
            if(akun instanceof AkunNasabah) {
                // return current account if match found
                if (((AkunNasabah) akun).getNomorRekening().equals(accountnumber)) {
                    return akun;
                }
            }
            // jika akun merupkana AkunAdmin, return akun
            else if(akun instanceof AkunAdmin) {
                // return current account if match found
                if (((AkunAdmin) akun).getPin().equals(pin)) {
                    return akun;
                }
            }

        } // end for

        return null; // if no matching account was found, return null
    } // end method getAccount

    private Akun getAccountpin(String PIN) {
        // loop through accounts searching for matching account number
        for (Akun currentAccount : databaseAkun) {
            // return current account if match found
            if (currentAccount.getPin() == PIN)
                return currentAccount;
        } // end for

        return null; // if no matching account was found, return null
    } //

    // determine whether user-specified account number and PIN match
    // those of an account in the database
    public boolean validasiPIN(int userPIN) {
        // attempt to retrieve the account with the account number
        Akun userAccount = getAccountpin(userPIN);

        // if account exists, return result of Account method validatePIN
        if (userAccount != null)
            return userAccount.validatePIN(userPIN);
        else
            return false; // account number not found, so return false
    } // end method authenticateUser

    // return available balance of Account with specified account number
    public double getAvailableBalance(int userAccountNumber) {
        return getAccount(userAccountNumber).getSaldoYangTersedia();
    } // end method getAvailableBalance

    // return total balance of Account with specified account number
    public double getTotalBalance(int userAccountNumber) {
        return getAccount(userAccountNumber).getTotalBalance();
    } // end method getTotalBalance

    // credit an amount to Account with specified account number
    public void credit(int userAccountNumber, double amount) {
        getAccount(userAccountNumber).credit(amount);
    } // end method credit

    // debit an amount from Account with specified account number
    public void debit(int userAccountNumber, double amount) {
        getAccount(userAccountNumber).debit(amount);
    } // end method debit

    public int getadmin(int userAccountNumber) {
        return getAccountpin(userAccountNumber).();
    }

    public static Iterator createIterator() {
        return new AkunIterator(databaseAkun);
    }

    public int getaccpin(int PIN) {
        for (Account currentAccount : accounts) {
            // return current account if match found
            if (currentAccount.GetPin() == PIN)
                return currentAccount.getAccountNumber();
            else
                return 1;
        } // end for
        return PIN;
    }

    public static void Adduser() {
        String name = Screen.Inputfield1.getText();
        int accountnumber = Integer.parseInt(Screen.Inputfield2.getText());
        int pin = Integer.parseInt(Screen.Inputfield4.getText());
        int balance = Integer.parseInt(Screen.Inputfield3.getText());

        Account newaccount = new Account(name, accountnumber, pin, balance, balance, 0);
        accounts.add(newaccount);

        Screen.Inputfield1.setText("");
        Screen.Inputfield2.setText("");
        Screen.Inputfield3.setText("");
        Screen.Inputfield4.setText("");
    }

    public static void Deleteuser(int position) {
        accounts.remove(position);

    }
}
