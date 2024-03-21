import java.util.Date;
public class Owner {

    private String name;
    private String adress;
    private int nik;
    private String job;
    private String gender;
    private Date dateOfBirth;

    public void setNik(int nik) {
        this.nik = nik;
    }
    public int getNik() {
        return nik;
    }

    public Owner(String name, String adress, int nik, String job, String gender, Date dateOfBirth) {
        this.name=name;
        this.adress=adress;
        this.nik=nik;
        this.job=job;
        this.gender=gender;
        this.dateOfBirth=dateOfBirth;
    }
}
