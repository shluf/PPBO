/******************************************************************************

Nama    : Salis Haidar Luthfi
NIM     : 23/513525/SV/22227

Pertemuan 1 | Latihan 1

*******************************************************************************/


import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.print( "Masukan angka pertama: ");
        int a = scan.nextInt();
        System.out.print( "Masukan angka kedua: ");
        int b = scan.nextInt();
        
        System.out.println();
            
        switch ((a % 2 == 0) ? 0 : ((a % 2 == 1) || (a % 2 == -1) ? 1 : -1)) {
            case 0:
                System.out.println(a + " Merupakan bilangan genap");
                break;
            case 1:
                System.out.println(a + " Merupakan bilangan ganjil");
            break;
        }
        
        switch ((a % 2 == 0) ? 0 : ((a % 2 == 1) || (a % 2 == -1) ? 1 : -1)) {
            case 0:
                System.out.println(b + " Merupakan bilangan genap");
                break;
            case 1:
                System.out.println(b + " Merupakan bilangan ganjil");
                break;
        }
            
        if (a > 0){
            System.out.println(a + " Merupakan bilangan positif");
            } else if (a == 0){
                System.out.println(a + " Merupakan bilangan nol");
                } else {
                    System.out.println(a + " Merupakan bilangan negatif");
            }
        
        if (b > 0){
            System.out.println(b + " Merupakan bilangan positif");
            } else if (b == 0){
                System.out.println(a + " Merupakan bilangan nol");
                } else {
                System.out.println(b + " Merupakan bilangan negatif");
            }
            
        int digitA = String.valueOf(a>=0 ? a : a*-1).length();
        System.out.println("Jumlah digit angka pertama: " + digitA);
        
        int digitB = String.valueOf(b>=0 ? b : b*-1).length();
        System.out.println("Jumlah digit angka kedua: " + digitB);
        
        int selisih = a>b ? a-b : b-a;
        System.out.println("Selisih kedua angka: " + selisih);
	}
}
