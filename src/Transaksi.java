/**
 * Fungsi class ini adalah sebagagi superclass dari class CekSaldo, TarikTunai, SetorTunai, Transfer, dan GantiPIn.
 * Class ini memiliki attribute formatUangRupiah bertipe DecimalFormat
 * yang digunakan untuk mengubah format angka menjadi format mata uang rupiah.
 *
 * Class ini memiliki method formatUangRupiah yang digunakan untuk
 * mengubah format angka menjadi format mata uang rupiah.
 *
 * Class ini memiliki modifier abstract yang berarti class Transaksi ini tidak bisa digunakan untuk membuat object
 * Class ini juga memiliki method abstract yang berarti method tersebut harus di override di class turunannya.
 * Class ini juga meng-implements interface FormatUang yang berarti class ini harus mengimplementasikan method formatUang
 */


import java.text.DecimalFormat; // digunakan untuk mengubah format angka menjadi format mata uang rupiah

public abstract class Transaksi implements FormatUang {
    // membuat object dari class DecimalFormat untuk mengubah format angka menjadi format mata uang rupiah
    DecimalFormat formatUangRupiah = new DecimalFormat("'Rp'###,##0.00");

    /**
     * Attribute objekAkunNasabah bertipe AkunNasabah digunakan untuk menyimpan object dari class AkunNasabah
     * yang akan digunakan untuk melakukan transaksi
     * Kenapa harus ada attribute objekAkunNasabah?
     * Supaya class Transaksi dan class turunannya bisa mengakses attribute dari class AkunNasabah yang sedang login sekarang
     */
    protected AkunNasabah objekAkunNasabah ;

    /**
     * Fungsi dari constructor ini adalah untuk membuat object dari class Transaksi
     * Dengan parameter objekAkunNasabah bertipe AkunNasabah,
     * yang nilainya akan digunakan untuk mengisi attribute objekAkunNasabah
     */
    public Transaksi(AkunNasabah objekAkunNasabah) {
        this.objekAkunNasabah = objekAkunNasabah;
    }



    /**
     * Fungsi dari method ini adalah untuk mengembalikan nilai dari attribute objekAkunNasabah
     * atau dengan kata lain mengambil object AkunNasabah yang sedang login sekarang.
     */
    public AkunNasabah getObjAkunNasabah() {
        return objekAkunNasabah;
    }

    /**
     * Fungsi dari method ini adalah mengubah angka biasa menjadi format mata uang rupiah
     * Dengan parameter value bertipe integer yang akan diubah menjadi format mata uang rupiah
     */
    public String formatUang(int value) {
        return formatUangRupiah.format(value);
    }

    /**
     * Fungsi dari method ini adalah untuk mengeksekusi transaksi yang dipilih,
     * tetapi karena method ini memiliki modifier abstract maka method ini harus di override di class turunannya.
     */
    public abstract  void prosesTransaksi();

}
