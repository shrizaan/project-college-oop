public class BuatAkun extends Akun {
    //This code is used for creating additional accounts to add to the database.
    public AccountFactory(String Username, int theAccountNumber, String thePIN, double theAvailableBalance,
                          double theTotalBalance, int isadmin) {
        super(Username, theAccountNumber, thePIN, theAvailableBalance, theTotalBalance, isadmin);
        setUsername(Username);
        setNomorRekening(theAccountNumber);
        setPin(thePIN);
        setAvailableBalance(theAvailableBalance);
        setTotalBalance(theTotalBalance);
        setAdmin(isadmin);
    }
}
