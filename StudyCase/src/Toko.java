import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Toko {
    enum TipeBarang {
        MEJA, KURSI, LEMARI
    }
    private List<Pembeli> antrian;
    private Gudang gudangBarang;

        public Toko() {
            antrian = new ArrayList<>();
            gudangBarang = new Gudang();
        }

        public Gudang getGudangBarang() {
            return gudangBarang;
        }

        public void tambahAntrian(Pembeli pembeli) {
            if (!antrianPenuh(pembeli.getBarangDiBeli(), pembeli.getJumlahBarang())) {
                antrian.add(pembeli);
                System.out.println("Berhasil menambah antrian");
            } else {
                System.out.println("Gagal menambah antrian");
            }
        }

        public void selesaikanAntrian() {
            List<Pembeli> antrianSelesai = new ArrayList<>();
            HashMap<TipeBarang, Integer> isiGudang = gudangBarang.getIsiGudang();

            for (Pembeli pembeli : antrian) {
                if (barangDiBeliTersedia(pembeli)) {
                    isiGudang.put(pembeli.getBarangDiBeli(),
                            isiGudang.get(pembeli.getBarangDiBeli()) - pembeli.getJumlahBarang());

                    antrianSelesai.add(pembeli);
                    System.out.println(pembeli.getJumlahBarang() + " " + pembeli.getBarangDiBeli()
                            + " berhasil dikeluarkan dari gudang");
                }
            }
            antrian.removeAll(antrianSelesai);
            System.out.println("Antrian terdepan berhasil di selesaikan");
        }

        public void cekIsiAntrian() {
            System.out.println("\n List Antrian:");
            for (Pembeli pembeli : antrian) {
                System.out.println("antrian ke " + (antrian.indexOf(pembeli) + 1)
                        + ", nama : " + pembeli.getNama()
                        + ", barang di beli " + pembeli.getBarangDiBeli()
                        + ", jumlah barang di beli : " + pembeli.getJumlahBarang());
            }
        }

        private boolean antrianPenuh(TipeBarang tipeBarang, int jumlahBarang) {
            int jumlahKursi = 0;
            int jumlahMeja = 0;
            int jumlahLemari = 0;

            switch (tipeBarang) {
                case KURSI:
                    jumlahKursi += jumlahBarang;
                    return jumlahKursi >= 20;
                case MEJA:
                    jumlahMeja += jumlahBarang;
                    return jumlahMeja >= 10;
                case LEMARI:
                    jumlahLemari += jumlahBarang;
                    return jumlahLemari >= 5;
            }
            return false;
        }

        private boolean barangDiBeliTersedia(Pembeli pembeli) {
            HashMap<TipeBarang, Integer> isiGudang = gudangBarang.getIsiGudang();
            int stokBarang = isiGudang.get(pembeli.getBarangDiBeli());
            return stokBarang >= pembeli.getJumlahBarang();
        }
}