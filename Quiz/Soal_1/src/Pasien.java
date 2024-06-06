public class Pasien {
    private String nama;
    private String tanggal_lahir;
    private orang.JENIS_KELAMIN jenisKelamin;
    private String pekerjaan;
    private String domisili;
    private String keluhan;
    private Antrian.tipePasiens tipePasiens;

    public Pasien(String nama, String tanggal_lahir, orang.JENIS_KELAMIN jenisKelamin, String pekerjaan, String domisili) {
        this.nama = nama;
        this.tanggal_lahir = tanggal_lahir;
        this.jenisKelamin = jenisKelamin;
        this.pekerjaan = pekerjaan;
        this.domisili = domisili;
    }

    public void daftar(RumahSakit rumahSakit, String keluhan, String namaDokter, Antrian.tipePasiens tipePasien) {
        boolean success = rumahSakit.tambahPasien(this, namaDokter);
        if (success) {
            this.keluhan = keluhan;
            this.tipePasiens = tipePasien;
            System.out.println("SUKSES");
        } else {
            System.out.println("DOKTER TERSEBUT TIDAK TERSEDIA");
        }
    }

    public void periksa(RumahSakit rumahSakit) {
        boolean success = rumahSakit.periksaPasien(this);
        if (success) {
            System.out.println("SUKSES");
        } else {
            System.out.println("BELUM SAATNYA PERIKSA");
        }
    }

    public String getNama() {
        return nama;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public Antrian.tipePasiens getTipePasiens() {
        return tipePasiens;
    }
}