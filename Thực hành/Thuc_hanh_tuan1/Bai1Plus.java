import java.util.Scanner;

public class Bai1Plus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap so nguyen n:");
        int n = in.nextInt();

        int [] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }

        for (int i = 0; i < array.length; i++) {
            if (isPrime(array[i])) {
                System.out.println("So nguyen to la: " + array[i]);
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
