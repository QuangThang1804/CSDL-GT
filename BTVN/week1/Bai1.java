import java.util.Scanner;

import static java.lang.Math.cbrt;
import static java.lang.Math.floor;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so lan test");
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            System.out.println("Nhap so muon test");
            int N = sc.nextInt();
            System.out.println((floor(cbrt(N))));
        }
    }
}