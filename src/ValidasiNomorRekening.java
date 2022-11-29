/**
 * Fungsi interface ini adalah untuk memvalidasi nomor rekening yang dimasukkan user.
 * Intefaace ini memiliki method validasiNomorRekening yang akan
 * memvalidasi nomor rekening yang dimasukkan user
 * Inteface dipakai pada class Akun.
 */
public interface ValidasiNomorRekening {
    public boolean validasiNomorRekening(String nomorRekening);
}
