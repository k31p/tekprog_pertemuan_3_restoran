/**
 * Class makanan dari hasil modifikasi 1
 * 
 * @author Yobel El'Roy Doloksaribu
 */
public class Makanan {
    private String nama;
    private double harga;
    private int stok;

    public Makanan(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    
    /** 
     * @param stok
     */
    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void kurangiStok() {
        if (stok != 0) {
            this.stok = stok - 1;
        }
    }
}