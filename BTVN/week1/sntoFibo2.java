import java.util.Scanner;

public class sntoFibo2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //System.out.println("Nhập số lần muốn test: ");
        int T = in.nextInt();
        
        for (int i = 1; i <= T; i++) {
            //System.out.println("Nhập số muốn test: ");
            int n = in.nextInt();
            if (haveAFibonacci(n) && n != 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static int isFibonacci(int n) {
        if (n == 1 || n == 2) {
            return  1;
        } else {
            return isFibonacci(n - 2) + isFibonacci(n - 1);
        }
    }

    public static boolean haveAFibonacci(int n) {
        for (int i = 1; i <= n + 2; i++) {
            if (n == isFibonacci(i)) {
                return true;
            }
        }
        return false;
    }
}