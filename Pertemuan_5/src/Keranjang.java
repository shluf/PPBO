import java.util.ArrayList;

public class Keranjang {
    private int jmlBarang;
    private ArrayList<Barang> listBarang;

    public Keranjang() {
        listBarang = new ArrayList<>();
        this.jmlBarang = 0;
    }

    public void tambahBarang(Barang barang){
        if(jmlBarang+barang.getJumlahBarang() <= 5){
            listBarang.add(barang);
            jmlBarang +=barang.getJumlahBarang();
            System.out.println("Berhasil memasukan ke kranjang");
        }else{
            System.out.println("Wes too, Keranjange wes mbludhag!!");
        }
    }

    public void printHasil() {
        System.out.println("\nJumlah Barang Di Keranjang Saat Ini : " + jmlBarang);
        System.out.println("Barang Pada Keranjang:");

        int totalHarga = 0;
        for (Barang barang : listBarang) {
            System.out.println("# " + barang.getNamaBarang() + ", Jumlah : " + barang.getJumlahBarang());
            totalHarga += barang.getHargaBarang() * barang.getJumlahBarang();
        }

        System.out.println("Total Harga Yang Harus di Bayar : " + totalHarga);
    }
}