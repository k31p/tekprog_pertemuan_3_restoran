public class RestaurantMain {
    
    /** 
     * Method utama program
     * @param args
     */
    public static void main(String[] args) {
        /*
         * MODIFIKASI
         * 
         * Memanggil nextId secara static langsung dari class Restaurant sangat
         * melanggar aturan
         * enkapsulasi serta membuat perintah yang tidak perlu
         */

        Restaurant restaurant = new Restaurant();
        RestaurantProses restaurantProses = new RestaurantProses();
        boolean prosesSelesai = false;

        while (!prosesSelesai) {
            restaurant.tampilMenuMakanan();
            prosesSelesai = restaurantProses.tampilOpsi();
        }
    }
}
