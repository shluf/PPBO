import java.util.HashMap;

public class Gudang {
    enum Bahan {
        KAYU, BAUT, CAT
    }
    private HashMap<Bahan, Integer> stokBahan;
    private HashMap<Toko.TipeBarang, Integer> isiGudang;

    public Gudang() {
        stokBahan = new HashMap<>();
        isiGudang = new HashMap<>();
        stokBahan.put(Bahan.KAYU, 0);
        stokBahan.put(Bahan.BAUT, 0);
        stokBahan.put(Bahan.CAT, 0);
        isiGudang.put(Toko.TipeBarang.MEJA, 0);
        isiGudang.put(Toko.TipeBarang.KURSI, 0);
        isiGudang.put(Toko.TipeBarang.LEMARI, 0);
    }

    public HashMap<Toko.TipeBarang, Integer> getIsiGudang() {
        return isiGudang;
    }

    public void cekStokBahan() {
        System.out.println("\n Stok Bahan:");
        System.out.println("Jumlah BAUT, saat ini adalah : " + stokBahan.get(Bahan.BAUT) + " buah");
        System.out.println("Jumlah KAYU, saat ini adalah : " + stokBahan.get(Bahan.KAYU) + " buah");
        System.out.println("Jumlah CAT, saat ini adalah : " + stokBahan.get(Bahan.CAT) + " buah");
    }

    public void cekIsiGudang() {
        System.out.println("\n Isi Gudang:");
        System.out.println("Jumlah MEJA, saat ini adalah : " + isiGudang.get(Toko.TipeBarang.MEJA ) + " buah");
        System.out.println("Jumlah KURSI, saat ini adalah : " + isiGudang.get(Toko.TipeBarang.KURSI) + " buah");
        System.out.println("Jumlah LEMARI, saat ini adalah : " + isiGudang.get(Toko.TipeBarang.LEMARI) + " buah");
    }

    public void tambahBahan(Bahan bahan, int jumlah) {
        stokBahan.put(bahan, stokBahan.get(bahan) + jumlah);
    }
    public void kurangiBahan(Bahan bahan, int jumlah) {
        stokBahan.put(bahan, stokBahan.get(bahan) - jumlah);
    }

    public void buatBarang(Toko.TipeBarang barang, int jumlah) {
        int kayuDibutuhkan = 0, bautDibutuhkan = 0, catDibutuhkan = 0;
        switch (barang) {
            case MEJA:
                kayuDibutuhkan = 3 * jumlah;
                bautDibutuhkan = 20 * jumlah;
                catDibutuhkan = 2 * jumlah;
                break;
            case KURSI:
                kayuDibutuhkan = 2 * jumlah;
                bautDibutuhkan = 10 * jumlah;
                catDibutuhkan = jumlah;
                break;
            case LEMARI:
                kayuDibutuhkan = 5 * jumlah;
                bautDibutuhkan = 30 * jumlah;
                catDibutuhkan = 3 * jumlah;
                break;
        }

        if (bahanPembuatanMencukupi(kayuDibutuhkan, bautDibutuhkan, catDibutuhkan)) {
            stokBahan.put(Bahan.KAYU, stokBahan.get(Bahan.KAYU) - kayuDibutuhkan);
            stokBahan.put(Bahan.BAUT, stokBahan.get(Bahan.BAUT) - bautDibutuhkan);
            stokBahan.put(Bahan.CAT, stokBahan.get(Bahan.CAT) - catDibutuhkan);

            masukanBarangKeGudang(barang, jumlah);
        } else {
            System.out.println("Gagal membuat "
                    + jumlah + " " + barang
                    + ", stok bahan tidak cukup");
        }
    }

    public boolean slotTersedia() {
        int jumlahKursi = isiGudang.get(Toko.TipeBarang.KURSI);
        int jumlahMeja = isiGudang.get(Toko.TipeBarang.MEJA);
        int jumlahLemari = isiGudang.get(Toko.TipeBarang.LEMARI);

        return jumlahKursi < 20 || jumlahMeja < 10 || jumlahLemari < 5;
    }

    public void masukanBarangKeGudang(Toko.TipeBarang barang, int jumlah) {
        if (slotTersedia()) {
            isiGudang.put(barang, isiGudang.get(barang) + jumlah);
            System.out.println("\n" + jumlah + " " + barang
                    + " berhasil di tambahkan ke gudang" );
        } else {
            System.out.println("Gagal memasukkan "
                    + jumlah + " " + barang
                    + " ke dalam gudang, kapasitas gudang penuh");
        }
    }

    public void keluarkanBarangDariGudang(Toko.TipeBarang barang, int jumlah) {
        if (isiGudang.get(barang) >= jumlah) {
            isiGudang.put(barang, isiGudang.get(barang) - jumlah);
            System.out.println("Berhasil mengeluarkan "
                    + jumlah + " " + barang
                    + " dari gudang");
        } else {
            System.out.println("Gagal mengeluarkan "
                    + jumlah + " " + barang
                    + " dari gudang, stok tidak mencukupi");
        }
    }

    private boolean bahanPembuatanMencukupi(int kayuDibutuhkan, int bautDibutuhkan, int catDibutuhkan) {
        return stokBahan.get(Bahan.KAYU) >= kayuDibutuhkan
                && stokBahan.get(Bahan.BAUT) >= bautDibutuhkan
                && stokBahan.get(Bahan.CAT) >= catDibutuhkan;
    }
}
