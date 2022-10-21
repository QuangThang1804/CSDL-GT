import java.util.Scanner;

public class sontgt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // System.out.print("Nhập số lần test: ");
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            // System.out.print("Nhập số muốn test: ");
            int N = in.nextInt();
            if (N == 1) {
                System.out.println("NO");
            } else {
                if (isPrime1(N)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static int isPrime(int x) {
        int prime = 1;
        for (int i = 1; i <= x; i++) {
            prime *= i;
        }
        return prime;
    }

    public static boolean isPrime1(int x) {
        for (int i = 1; i <= x; i++) {
            if (x == isPrime(i) || x == isPrime(i) + 1 || x == isPrime(i) - 1) {
                return true;
            }
        }
        return false;
    }
}
