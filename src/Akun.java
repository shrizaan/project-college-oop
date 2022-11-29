/**
 * Fungsi Class Akun dibuat sebagai superclass dan akan diturunkan ke clas AkunAdmin dan AkunNasabah,
 * Class ini harus ada untuk menerapkan konsep inheritance
 * Class ini memiliki attribute username, nomorRekening, dan pin yang semuanya bertipe String
 * Class ini memiliki Conctructor yang menerima parameter username, nomorRekening, dan pin semuanya bertipe string
 * Class ini meng-implements interface ValidasiNomorRekening dan ValidasiPin
 * Class ini juga menyediakan seluruh method getter dan setter untuk setiap attribute yang ada di class ini
 */
public class  Akun implements ValidasiNomorRekening, ValidasiPin {
    protected String username;
    protected String nomorRekening;
    protected String pin;

    /**
     * Fungsi dari constructor ini adalah untuk membuat object dari class Akun
     * @param username
     * @param nomorRekening
     * @param pin
     */
    public Akun(String username, String nomorRekening, String pin) {
        this.nomorRekening = nomorRekening;
        this.username = username;
        this.pin = pin;
    }

    /**
     * class ini dipanggil ketika user ingin melakukan login tepatnya pada class DatabaseAkun,
     * jadi nilai yang dimasukkan user akan diteruskan ke pemanggilan method ini
     * setelah itu nilai nya akan dibandingkan dengan nilai attribute nomorRekening
     * pada object AkunAdmin atau AkunNasabah
     * @paramater nomorRekening
     * @return nilai boolean
     */
    public boolean validasiNomorRekening(String nomorRekening) {
        if (nomorRekening.equals(this.nomorRekening)) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * class ini dipanggil ketika user ingin melakukan login tepatnya pada class DatabaseAkun,
     * jadi nilai yang dimasukkan user akan diteruskan ke pemanggilan method ini
     * setelah itu nilai nya akan dibandingkan dengan nilai attribute nomorRekening
     * pada object AkunAdmin atau AkunNasabah
     * @paramater pin
     * @return nilai boolean
     */
    public boolean validasiPin(String pin) {
        if (pin.equals(this.pin)) {
            return true;
        }
        else {
            return false;
        }
    }
}