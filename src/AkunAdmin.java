/**
 * Fungsi class AkunAdmin adalah sebagai subclass dari class Akun
 * dan akan digunakan untuk membuat object dari class AkunAdmin yang akan digunakan untuk login khusus admin.
 * Class ini digunakan ketika membuat object dari class DatabaseAkun dan akan disimpan didalam array databaseAKun
 * Class ini merupakan subclass dari superclass Akun.
 * Classs ini memiliki attribute isAdmin bertipe boolean yang gunanya membuktikan
 * bahwa object ini adalah object dari class AkunAdmin.
 */
public class AkunAdmin extends Akun {
    // attribute isAdmin digunakan untuk membuktikan bahwa suatu object yang dibuat dari class AkunAdmin adalah benar admin
    private boolean isAdmin;

    /**
     * Fungsi dari constructor ini adalah untuk membuat object dari class AkunAdmin
     * @paramater username
     * @paramater nomorRekening
     * @paramater pin
     * @paramater isAdmin
     */
    public AkunAdmin(String username, String nomorRekening, String pin, boolean isAdmin) {
        // memanggil method super dari class Akun untuk mengisi attribute username, nomorRekening, dan pin
        super( username, nomorRekening,  pin);
        // mengisi attribute isAdmin dengan parameter isAdmin
        // melakukan pengecekan apakah parameter isAdmin adalah true atau false
        if (isAdmin == true) {
            // jika parameter isAdmin adalah true, maka attribute isAdmin akan diisi dengan true
            setIsAdmin(isAdmin);
        } else {
            // jika parameter isAdmin adalah false, maka attribute isAdmin akan diisi dengan false
            // dan akan menampilkan pesan error tidak bisa membuat akun admin
            System.out.println("Tidak bisa membuat akun admin");
        }

    }

    /**
     * Fungsi dari method ini adalah untuk mengecek apakah object yang dibuat dari class AkunAdmin adalah admin atau bukan
     * mengembalikan nilai attribute admin
     */
    public boolean getIsAdmin() {
        return isAdmin;
    }

    /**
     * Fungsi dari method ini adalah untuk mengubah nilai dari attribute isAdmin
     * menerima parameter berupa nilai boolean admin
     */
    public void setIsAdmin(boolean admin) {
        this.isAdmin = isAdmin;
    }
}
