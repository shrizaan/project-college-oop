public class AkunAdmin extends Akun {
    private boolean isAdmin;

    public AkunAdmin(String username, String nomorRekening, String pin, boolean isAdmin) {
        super( username, nomorRekening,  pin);
        this.isAdmin = isAdmin;
    }

    public boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        this.isAdmin = isAdmin;
    }
}
