/**
 * Fungsi interface ini adalah untuk mengubah nilai uang menjadi format rupiah
 * sehingga lebih mudah dibaca.
 * Interface ini digunakan ketika ingin mengubah nilai uang menjadi format rupiah.
 * Intefaace ini memiliki method formatUang yang akan mengubah nilai uang menjadi format rupiah.
 * Inteface dipakai pada class Transaksi
 */
public interface FormatUang {
    // method ini digunakan untuk mengubah nilai uang menjadi format rupiah
    String formatUang(int value);
}
