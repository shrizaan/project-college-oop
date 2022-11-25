public class AkunAdmin extends Akun {
    private boolean isAdmin;

    public AkunAdmin(String Username, String pin, boolean isAdmin) {
        super( Username,  pin);
        this.isAdmin = isAdmin;
    }

    public boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        this.isAdmin = isAdmin;
    }
}
