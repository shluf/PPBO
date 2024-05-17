public class Manager extends Pegawai{
    public Manager(String nama, String departemen, char jenisKelamin) {
        super(nama, departemen, jenisKelamin);
    }

    @Override
    public void displayInfo() {
        System.out.println("Jabatan : Manager");
        System.out.println("Nama : " + getNama());
        System.out.println("Departemen : " + getDepartemen());
        System.out.println("NIP : " + getNip());
        System.out.println("Gaji : " + getGaji());
        System.out.println("Gaji : " + calculateTHR());
        System.out.println("Cuti : " + getCuti());
        System.out.println("=======================================");
    }

    public int calculateTHR() {
        return getGaji() * 2;
    }
}


