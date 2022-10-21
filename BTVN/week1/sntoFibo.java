import java.util.Scanner;

public class sntoFibo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập số lần muốn test: ");
        int T = in.nextInt();
        
        for (int i = 1; i <= T; i++) {
            System.out.println("Nhập số muốn test: ");
            int n = in.nextInt();
            if (haveAFibonacci(n)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean haveAFibonacci(int n) {
        int [] isFibonacci = new int[n + 2];
        isFibonacci[0] = 1;
        isFibonacci[1] = 1;
        for (int i = 2; i < isFibonacci.length; i++) {
            isFibonacci[i] = isFibonacci[i - 1] + isFibonacci[i - 2];
        }
        for (int i = 0; i < isFibonacci.length; i++) {
            if (n == isFibonacci[i]) {
                return true;
            }
        }
        return false;
    }
}
