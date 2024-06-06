import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RumahSakit {
    private String nama;
    private String alamat;
    private String noTelepon;
    private List<Dokter> dokterList;
    private Map<String, Dokter> namaDokterMap;

    public RumahSakit(String nama, String alamat, String noTelepon) {
        this.nama = nama;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.dokterList = new ArrayList<>();
        this.namaDokterMap = new HashMap<>();
    }

    public void tambahDokter(Dokter dokter) {
        if (dokterList.contains(dokter)) {
            System.out.println("DOKTER SUDAH TERDAFTAR");
        } else {
            dokterList.add(dokter);
            namaDokterMap.put(dokter.getNama(), dokter);
            System.out.println("SUKSES");
        }
    }

    public boolean tambahPasien(Pasien pasien, String namaDokter) {
        Dokter dokter = namaDokterMap.get(namaDokter);
        if (dokter != null) {
            dokter.tambahPasien(pasien);
            return true;
        }
        return false;
    }

    public boolean periksaPasien(Pasien pasien) {
        for (Dokter dokter : dokterList) {
            if (dokter.getAntrianPasien()) {
                dokter.periksaPasien(pasien);
                return true;
            }
        }
        return false;
    }

    public void cekListDokter() {
        if (dokterList.isEmpty()) {
            System.out.println("BELUM ADA DOKTER TERSEDIA SAAT INI");
        } else {
            System.out.println("BERIKUT LIST DOKTER YANG TERSEDIA SAAT INI");
            System.out.println("==========================================");
            int n = 1;
            for (Dokter dokter : dokterList) {
                System.out.println(n + ". Nama Dokter: " + dokter.getNama() + ", Dokter spesialis: " + dokter.getSpesialis());
                n++;
            }
        }
    }

    public void cekAntrianPasien() {
        System.out.println("ANTRIAN RUMAH SAKIT SAAT INI");
        System.out.println("============================");
        for (Dokter dokter : dokterList) {
            System.out.println("DR. " + dokter.getNama());
            dokter.getAntrianPasien();
        }
    }
}