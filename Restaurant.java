public class Restaurant {
    /*
     MODIFIKASI 1:
     nama_makanan dan harga_makanan dapat disatukan dalam class yang baru menjadi class Makanan
     hal ini dilakukan supaya class Restaurant ini dapat lebih mudah untuk dibaca

     Juga jika kita lihat access modifier pada setiap attribute tidak mengikuti konsep enkapsulasi,
     jadi kita juga perlu untuk merubah access modifier menjadi private

     juga dikarenakan makanan dan restaurant memiliki method yang berbeda, lebih baik untuk dipisahkan
     agar setiap class hanya memiliki satu bidang saja
    */
    private int MAX_MENU;
    private short indexMenu;
    private Makanan listMakanan[];

    public Restaurant(){
        MAX_MENU = 12;
        indexMenu = 9;
        listMakanan = new Makanan[MAX_MENU];
        
        listMakanan[0] = new Makanan("Bala-Bala", 1_000, 10);
        listMakanan[1] = new Makanan("Gehu", 1_000, 10);
        listMakanan[2] = new Makanan("Tahu", 1_000, 10);
        listMakanan[3] = new Makanan("Molen", 1_000, 10);
        listMakanan[4] = new Makanan("Kopi Hitam", 3_000, 10);
        listMakanan[5] = new Makanan("Indomie", 4_500, 0);
        listMakanan[6] = new Makanan("Nasi Goreng", 10_000, 10);
        listMakanan[7] = new Makanan("Susu", 3_000, 10);
        listMakanan[8] = new Makanan("Teh Tarik", 4_500, 10);
        listMakanan[9] = new Makanan("Surprise Food", 12_000, 10);
    }

    
    /** 
     * @param nama
     * @param harga
     * @param stok
     */
    public void tambahMenuMakanan(String nama, double harga, int stok) {
        if(indexMenu == MAX_MENU - 1){
            System.out.println("Menu sudah penuh!");
            return;
        }

        listMakanan[indexMenu] = new Makanan(nama, harga, stok);
        indexMenu++;
    }

    public void tampilMenuMakanan() {
        System.out.println("====================== MENU MAKANAN ======================");
        for (int i = 0; i < indexMenu; i++) {
            System.out.println(
                (i+1) + ". " + 
                listMakanan[i].getNama() + 
                ((listMakanan[i].getNama().length() > 4) ? "\t" : "\t\t") +
                "[" + 
                (listMakanan[i].getStok() == 0 ? "HABIS" : listMakanan[i].getStok()) + 
                "]\t" + 
                "Rp. " + 
                listMakanan[i].getHarga()
            );
        }
        System.out.println("==========================================================");
    }

    public Makanan getMakanan(short indexMenu){
        Makanan makanan = listMakanan[indexMenu - 1];
        return makanan;
    }

    public boolean isOutOfStock(short indexMenu) {
        if(listMakanan[indexMenu].getStok() == 0){
            return true;
        } else {
            return false;
        }
    }
}