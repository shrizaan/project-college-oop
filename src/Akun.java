/**
 * Fungsi Class Akun dibuat sebagai superclass dan akan diturunkan ke clas AkunAdmin dan AkunNasabah,
 * Class ini harus ada untuk menerapkan konsep inheritance
 * Class ini memiliki attribute username, nomorRekening, dan pin yang semuanya bertipe String
 * Class ini memiliki Conctructor yang menerima parameter username, nomorRekening, dan pin semuanya bertipe string
 * Class ini meng-implements interface ValidasiNomorRekening dan ValidasiPin
 * Class ini juga menyediakan seluruh method getter dan setter untuk setiap attribute yang ada di class ini
 */
public class  Akun implements ValidasiNomorRekening, ValidasiPin {
    private String username;
    private String nomorRekening;
    private String pin; //

    /**
     * Fungsi dari constructor ini adalah untuk membuat object dari class Akun
     * @param username
     * @param nomorRekening
     * @param pin
     */
    public Akun(String username, String nomorRekening, String pin) {
        setNomorRekening(nomorRekening);
        setUsername(username);
        setPin(pin);
    }

    //    class ini dipanggil ketika user ingin melakukan login tepatnya pada class DatabaseAkun,
//    jadi nilai yang dimasukkan user akan diteruskan ke pemanggilan method ini
//    setelah itu nilai nya akan dibandingkan dengan nilai attribute nomorRekening pada object AkunAdmin atau AkunNasabah
    public boolean validasiNomorRekening(String nomorRekening) {
        if (nomorRekening.equals(this.nomorRekening)) {
            return true;
        }
        else {
            return false;
        }
    }

//    class ini dipanggil ketika user ingin melakukan login tepatnya pada class DatabaseAkun,
//    jadi nilai yang dimasukkan user akan diteruskan ke pemanggilan method ini
//    setelah itu nilai nya akan dibandingkan dengan nilai attribute nomorRekening pada object AkunAdmin atau AkunNasabah
    public boolean validasiPin(String pin) {
        if (pin.equals(this.pin)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Fungsi dari method ini adalah untuk mengembalikan nilai dari attribute username
     * Mengembalikan nilai attribute nomorRekening
     */
    public String getNomorRekening() {
        return nomorRekening;
    }

    /**
     * Fungsi dari method ini adalah untuk mengubah nilai dari attribute nomorRekening
     * menerima parameter berupa nilai String nomorRekening
     */
    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    /**
     * Fungsi dari method ini adalah untuk mengembalikan nilai dari attribute pin
     * Mengembalikan nilai attribute pin
     */
    public String getPin() {
        return pin;
    }

    /**
     * Fungsi dari method ini adalah untuk mengubah nilai dari attribute pin
     * menerima parameter berupa nilai String pin
     */
    public void setPin(String pin) {
        this.pin = pin;
    }

    /**
     * Fungsi dari method ini adalah untuk mengembalikan nilai dari attribute username
     * Mengembalikan nilai attribute username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Fungsi dari method ini adalah untuk mengubah nilai dari attribute username
     * menerima parameter berupa nilai String username
     */
    public void setUsername(String username) {
        this.username = username;
    }

}