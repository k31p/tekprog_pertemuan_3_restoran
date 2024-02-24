import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantProses {
    ArrayList<Produk> listProduk = new ArrayList<Produk>();
    private byte pilihan;
    private boolean exited = false;
    private Scanner scanner = new Scanner(System.in);

    
    /** 
     * @return boolean
     */
    public boolean tampilOpsi(){
        System.out.println("1. Pesan");
        System.out.println("2. Lihat Pesanan");
        System.out.println("3. Exit");
        exited = prosesOpsi();

        return exited;
    }

    private void finalisasiPembelian(ArrayList<Produk> listProduk){
        if(listProduk.isEmpty()){
            System.out.println("Anda belum memesan apapun");
        } else {
            String namaPembeli;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Masukkan nama anda: ");
            namaPembeli = scanner.nextLine();

            Penjualan penjualan = new Penjualan("PEMBELIAN ATAS NAMA " + namaPembeli, listProduk);
            penjualan.finalisasiPenjualan();
            scanner.close();
        }
    }

    private void tampilListProduk(){
        if(listProduk.isEmpty()){
            System.out.println("Anda belum memesan apapun");
            return;
        }
        
        System.out.println("================= MAKANAN YANG ANDA PESAN ======================");
        Penjualan.showAllProducts(listProduk);
    }

    private boolean prosesOpsi(){
        System.out.print("Pilih: ");
        pilihan = scanner.nextByte();

        switch (pilihan) {
            case 1:
                exited = pesanMakanan();
                break;
            case 2:
                exited = false;
                tampilListProduk();
                break;
            case 3:
                exited = true;
                System.out.println("Selamat tinggal");
                break;
            default:
                exited = false;
                System.out.println("Pilihan invalid...");
                break;
        }
        
        return exited;
    }

    private boolean pesanMakanan(){
        byte pilihanMenu = 0;
        int quantity;

        Restaurant restaurant = new Restaurant();
        restaurant.tampilMenuMakanan();
        System.out.print("Makanan apa yang akan anda beli? ");
        pilihanMenu = scanner.nextByte();
        System.out.print("Quantity: ");
        quantity = scanner.nextInt();

        Makanan makanan = restaurant.getMakanan(pilihanMenu);
        if(quantity > makanan.getStok()){
            System.out.println("Pemesanan gagal, stok kurang!");
            return false;
        }

        listProduk.add(new Produk(makanan.getNama(), makanan.getHarga(), quantity));
        
        char pilihanLanjut;
        System.out.print("Apakah anda mau memesan lagi (Y/N)? ");
        pilihanLanjut = scanner.next().charAt(0);
        
        if (pilihanLanjut != 'Y' && pilihanLanjut != 'y') {
            finalisasiPembelian(listProduk);
            return true;
        }

        return false;
    }
}