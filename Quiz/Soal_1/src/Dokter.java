import java.util.ArrayList;
import java.util.List;

public class Dokter {
    private String nama;
    private String tanggalLahir;
    private orang.JENIS_KELAMIN jenisKelamin;
    private String nomorRegistrasi;
    private String spesialis;
    private List<Pasien> antrianPasien;

    public Dokter(String nama, String tanggalLahir, orang.JENIS_KELAMIN jenisKelamin, String nomorRegistrasi, String spesialis) {
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.jenisKelamin = jenisKelamin;
        this.nomorRegistrasi = nomorRegistrasi;
        this.spesialis = spesialis;
        this.antrianPasien = new ArrayList<>();
    }

    public String getNama() {
        return nama;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public void daftar(RumahSakit rumahSakit) {
        rumahSakit.tambahDokter(this);
        System.out.println("SUKSES");
    }

    public void tambahPasien(Pasien pasien) {
        if (antrianPasien.contains(pasien)) {
            System.out.println("PASIEN SUDAH TERDAFTAR");
        } else {
            antrianPasien.add(pasien);
        }
    }

    public void periksaPasien(Pasien pasien) {
        if (antrianPasien.contains(pasien)) {
            antrianPasien.remove(pasien);
        }
    }

    public boolean getAntrianPasien() {
        if (antrianPasien.isEmpty()) {
            System.out.println("ANTRIAN KOSONG");
        } else {
            for (int i = 0; i < antrianPasien.size(); i++) {
                Pasien p = antrianPasien.get(i);
                System.out.println("ID ANTRIAN: D_" + spesialis + "_" + (i + 1) + ", Atas nama: " + p.getNama());
            }
        }
        return false;
    }
}