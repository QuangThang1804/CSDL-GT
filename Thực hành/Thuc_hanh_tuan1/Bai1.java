import java.util.Scanner;

public class Bai1{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Nhap so nguyen n:");
        int n = in.nextInt();

        int [] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }

        for (int i = 0; i < array.length; i++) {
            if (isPerfectNumber(array[i])) {
                System.out.println("So hoan hao la: " + array[i]);
            }
        }
    }

    public static boolean isPerfectNumber(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        
        if (sum == number) {
            return true;
        } else {
            return false;
        }
    }
}