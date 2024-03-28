/******************************************************************************

Nama    : Salis Haidar Luthfi
NIM     : 23/513525/SV/22227

Pertemuan 2 | Latihan 1

*******************************************************************************/

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan ukuran area: ");
        int area = scanner.nextInt();

        System.out.println("Masukkan titik start x: ");
        int startX = scanner.nextInt();

        System.out.println("Masukkan titik start y: ");
        int startY = scanner.nextInt();

        System.out.println("Masukkan titik finish x: ");
        int finishX = scanner.nextInt();

        System.out.println("Masukkan titik finish y: ");
        int finishY = scanner.nextInt();

        System.out.println();
        System.out.println("Titik Start: (" + startX + ", " + startY + ")");
        System.out.println("Titik Finish: (" + finishX + ", " + finishY + ")");
    
        char[][] peta = new char[area][area];

        peta[startX][startY] = 'S';
        peta[finishX][finishY] = 'F';

        for (int i = 0; i < peta.length; i++) {
            for (int j = 0; j < peta[i].length; j++) {
                
                if (peta[j][i] == 'S') {
                    System.out.print(" S |");
                } else if (peta[j][i] == 'F') {
                    System.out.print(" F |");
                }else {
                    System.out.print(" * |");
                }
            }
            System.out.println();
        }
        
        System.out.println();
        System.out.println("Jalan:");
        
        int currentX = startX;
        int currentY = startY;
        
        do{
            System.out.println("Robot sekarang ada di titik " + currentX + ", " + currentY);
            if (currentX < finishX) {
                currentX++;
            } else if (currentX > finishX) {
                currentX--;
            } else if (currentY < finishY) {
                currentY++;
            } else if (currentY > finishY) {
                currentY--;
            }
        } while (currentX != finishX || currentY != finishY) ;
        System.out.println("Robot sekarang ada di titik " + currentX + ", " + currentY);
    }
}
