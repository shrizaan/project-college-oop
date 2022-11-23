public class TampilanUtama  {
    public void pilihBahasa() {

    }

    public void pilihMenu(){
        System.out.println("Selamat datang di Simulasi ATM WGO");
        System.out.println("Masukkan menu yang diinginkan: ");
        System.out.println("1. Cek Saldo");
        System.out.println("2. Tarik Tunai");
        System.out.println("3. Setor Tunai");
        System.out.println("4. Ganti PIN");
        System.out.println("5. Keluar");
    }

    public void layarCekSaldo() {
        System.out.println("Saldo Anda: ");
    }

    public void layarTarikTunai() {
        System.out.println("Masukkan jumlah uang yang ingin Anda tarik: ");
    }

    public void layarSetorTunai() {
        System.out.println("Masukkan jumlah uang yang ingin Anda setor: ");
    }

    public void layarGantiPIN() {
        System.out.println("Masukkan PIN baru: ");
    }

    public void layarKeluar() {
        System.out.println("Terima kasih telah menggunakan ATM WGO");
    }
}
