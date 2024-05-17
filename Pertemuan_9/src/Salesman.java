public class Salesman extends Pegawai {
    private int target;
    private int penjualan;

    public Salesman(String nama, String departemen, char jenisKelamin) {
        super(nama, departemen, jenisKelamin);
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public void setPenjualan(int penjualan) {
        this.penjualan = penjualan;
    }

    @Override
    public void displayInfo() {
        System.out.println("Jabatan : Pegawai");
        System.out.println("Nama : " + getNama());
        System.out.println("Departemen : " + getDepartemen());
        System.out.println("NIP : " + getNip());
        System.out.println("Gaji : " + getGaji());
        System.out.println("Gaji : " + calculateTHR());
        System.out.println("Cuti : " + getCuti());
        System.out.println("=======================================");
    }

    public int calculateTHR() {
        if (penjualan >= target) {
            return getGaji() * 2;
        } else {
            return getGaji();
        }
    }
}


