public class AkunAdmin extends Akun {
    private boolean isAdmin;

    public AkunAdmin(String username, String nomorRekening, String pin, boolean isAdmin) {
        super( username, nomorRekening,  pin);
        if (isAdmin == true) {
            this.isAdmin = isAdmin;
        } else {
            System.out.println("Tidak bisa membuat akun admin");
        }
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
