public class Pembeli {
    private String nama;
    private Toko.TipeBarang barangDiBeli;
    private int jumlahBarang;

        public Pembeli(String nama, Toko.TipeBarang tipeBarang, int jumlahBarang) {
            this.nama = nama;
            this.barangDiBeli = tipeBarang;
            this.jumlahBarang = jumlahBarang;
        }

        public String getNama() {
            return nama;
        }

        public Toko.TipeBarang getBarangDiBeli() {
            return barangDiBeli;
        }

        public int getJumlahBarang() {
            return jumlahBarang;
        }
}
