

// AkunNasabah.java
// Merepresentasikan akun bank

public class AkunNasabah extends Akun
{
    private String nomorRekening; // account number
    private double saldo; // saldo yang tersedia yang dapat ditarik
    private double totalSaldo; // saldo yang tersedia untuk ditarik + saldo yang belum ditarik

    public AkunNasabah(String username, String nomorRekening, String pin, int saldoYangTersedia, int totalSaldo) {
        super( username, pin);
        setNomorRekening(nomorRekening);
        setSaldoYangTersedia(saldoYangTersedia);
        setTotalSaldo(totalSaldo);
    }

    // credits an amount to the account
    public void credit(double amount)
    {
        setTotalSaldo(getTotalSaldo() + amount); // add to total balance
    } // end method credit

    // debits an amount from the account
    public void debit(double amount)
    {
        setSaldoYangTersedia(getSaldoYangTersedia() - amount); // subtract from available balance
        setTotalSaldo(getTotalSaldo() - amount); // subtract from total balance
    } // end method debit

    public String getNomorRekening()
    {
        return nomorRekening;
    } // end method getAccountNumber

    public double getSaldoYangTersedia()
    {
        return saldoYangTersedia;
    } // end getAvailableBalance

    // returns the total balance
    public double getTotalSaldo()
    {
        return totalSaldo;
    } // end method getTotalBalance

    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    public void setSaldoYangTersedia(double saldoYangTersedia) {
        this.saldoYangTersedia = saldoYangTersedia;
    }

    public void setTotalSaldo(double totalSaldo) {
        this.totalSaldo = totalSaldo;
    }

}

