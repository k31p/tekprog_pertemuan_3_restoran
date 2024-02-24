public class Produk {
    private String nama;
    private double harga;
    private int quantity;

    public Produk(String nama, double harga, int quantity) {
        this.nama = nama;
        this.harga = harga;
        this.quantity = quantity;
    }

    
    /** 
     * @param nama
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNama() {
        return nama;
    }

}
