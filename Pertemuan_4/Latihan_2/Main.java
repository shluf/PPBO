/******************************************************************************

Nama    : Salis Haidar Luthfi
NIM     : 23/513525/SV/22227

Pertemuan 2 | Latihan 2

*******************************************************************************/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan size array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        System.out.println("Masukkan elemen array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        int max = arr[0];

        System.out.println("Elemen array:");
        for (int i = 0; i < size; i++) {
            if (i+1 == size) {
                System.out.print(arr[i]);
            } else{
                System.out.print(arr[i] + ", ");
            }
            
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("\nAngka terbesar: " + max);
    }
}
