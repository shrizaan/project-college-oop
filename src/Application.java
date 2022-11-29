/**
 * Fungsi class ini adalah untuk menjalankan program simulasi ATM,
 * karena memiliki method main yang akan menjalan method login menggunakan object ATM
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("|====================================|");
        System.out.println("|~~~Selamat datang di ATM Bank WKG~~~|");
        System.out.println("|====================================|");
//        Membuat object dari class ATM untuk melakukan login
        ATM atm = new ATM();
        atm.login();
    }
}

