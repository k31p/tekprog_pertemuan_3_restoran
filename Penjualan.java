import java.util.ArrayList;

public class Penjualan {
    private String namaPenjualan;
    private ArrayList<Produk> listProduk = new ArrayList<Produk>();
    private double total;

    public Penjualan(String namaPenjualan, ArrayList<Produk> listProduk) {
        this.namaPenjualan = namaPenjualan;
        this.listProduk = listProduk;
        this.total = 0;
    }

    
    /** 
     * @param listProduk
     */
    public static void showAllProducts(ArrayList<Produk> listProduk){
        int counter = 1;
        System.out.println("  MAKANAN\t QUANTITY\t SUBTOTAL");
        for (Produk produk : listProduk) {
            System.out.printf("%d. %s%s %d\t Rp. %.2f\n", counter++, produk.getNama(), (produk.getNama().length() > 4 ? "\t" : "\t\t"),produk.getQuantity(), produk.getQuantity() * produk.getHarga());
        }
    }

    public void finalisasiPenjualan(){
        for (Produk produk : listProduk) {
            total += produk.getHarga() * produk.getQuantity();
        }

        
        System.out.println("=========================== CHECKOUT ===================================");
        showAllProducts(listProduk);
        System.out.printf("TOTAL = Rp. %.2f\n", total);
    }

    public String getNamaPenjualan() {
        return namaPenjualan;
    }

    public void setNamaPenjualan(String nama_penjualan) {
        this.namaPenjualan = nama_penjualan;
    }

    public ArrayList<Produk> getListProduk() {
        return listProduk;
    }

    public void setListProduk(ArrayList<Produk> list_produk) {
        this.listProduk = list_produk;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
