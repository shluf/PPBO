public class Pegawai {
    private String nama;
    private String departemen;
    private char jenisKelamin;
    private String nip;
    private int gaji;
    private int cuti = 12;

    public Pegawai(String nama, String departemen, char jenisKelamin) {
        this.nama = nama;
        this.departemen = departemen;
        this.jenisKelamin = jenisKelamin;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    public void setCuti(int cuti) {
        this.cuti += cuti;
    }

    public void setCuti(String tipe) {
        if (tipe.equalsIgnoreCase("pernikahan")) {
            this.cuti += 2;
        } else if (tipe.equalsIgnoreCase("persalinan")) {
            if (jenisKelamin == 'L') {
                this.cuti += 3;
            } else {
                this.cuti += 90;
            }
        }
    }

    public void setNip(String nip) {
        if (nip.matches("^[PSM]\\d{4}$")) {
            this.nip = nip;
        }
    }

    public void setNip(int urutanMasuk) {
        switch (this) {
            case Salesman salesman -> this.nip = "S" + String.format("%04d", urutanMasuk);
            case Manager manager -> this.nip = "M" + String.format("%04d", urutanMasuk);
            case Pegawai pegawai -> this.nip = "P" + String.format("%04d", urutanMasuk);
        }
    }

    public int calculateTHR() {
        return getGaji();
    }

    public String getNama() {
        return nama;
    }

    public String getDepartemen() {
        return departemen;
    }

    public String getNip() {
        return nip;
    }

    public int getGaji() {
        return gaji;
    }

    public int getCuti() {
        return cuti;
    }

    public void displayInfo() {
        System.out.println("Jabatan : Pegawai");
        System.out.println("Nama : " + nama);
        System.out.println("Departemen : " + departemen);
        System.out.println("NIP : " + nip);
        System.out.println("Gaji : " + gaji);
        System.out.println("Gaji : " + gaji);
        System.out.println("Cuti : " + cuti);
        System.out.println("=======================================");
    }
}


