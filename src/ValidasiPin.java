/**
 * Fungsi inteface adalah untuk memvalidasi pin yang dimasukkan user.
 * Intefaace ini memiliki method validasiPin
 * yang akan memvalidasi pin yang dimasukkan user
 * Inteface dipakai pada class Akun.
 */
public interface ValidasiPin {
    public boolean validasiPin(String pin);
}
