/******************************************************************************

Nama    : Salis Haidar Luthfi
NIM     : 23/513525/SV/22227

Pertemuan 1 | Latihan 2

*******************************************************************************/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Nama Siswa");
        String namaSiswa = scanner.nextLine();

        System.out.println("Nilai Matematika");
        double nilaiMatematika = scanner.nextDouble();

        System.out.println("Nilai IPA");
        double nilaiIPA = scanner.nextDouble();

        System.out.println("Nilai Bahasa Indonesia");
        double nilaiBahasaIndonesia = scanner.nextDouble();

        System.out.println("Nilai Bahasa Inggris");
        double nilaiBahasaInggris = scanner.nextDouble();

        double rataRata = (nilaiMatematika + nilaiIPA + nilaiBahasaIndonesia + nilaiBahasaInggris) / 4;

        System.out.printf("%s mendapatkan nilai rata-rata sebesar %.2f, dan dinyatakan %s%n",
                          namaSiswa, rataRata, (rataRata > 50 ? "lulus" : "tidak lulus"));

    }
}
