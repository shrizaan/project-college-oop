public class AkunAdmin extends Akun {
    // attribute isAdmin digunakan untuk membuktikan bahwa suatu object yang dibuat dari class AkunAdmin adalah benar admin
    private boolean isAdmin;

    public AkunAdmin(String username, String nomorRekening, String pin, boolean isAdmin) {
        super( username, nomorRekening,  pin);
        if (isAdmin == true) {
            this.isAdmin = isAdmin;
        } else {
            System.out.println("Tidak bisa membuat akun admin");
        }

    }

    public boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        this.isAdmin = isAdmin;
    }
}
