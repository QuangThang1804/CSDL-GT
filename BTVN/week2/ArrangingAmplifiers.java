import java.util.Scanner;
import java.util.Arrays;

public class ArrangingAmplifiers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so lan test");
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            System.out.println("Nhap so bo khuyech dai: ");
            int n = sc.nextInt();
            int [] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = sc.nextInt();
            }
            Arrays.sort(array);
            
            int count = 0, count1 = 0, input = 0;
            for (int j = 0; j < n; j++) {
                if (array[j] == 1) {
                    System.out.print(1 + " ");
                    count1++;
                }
            }
            for (int j = n - 1; j >= count1; j--) {
                if (n - count1 == 2 && array[n - 2] == 2 && array[n - 1] == 3) {
                    System.out.println(2 + " " + 3);
                    break;
                } else {
                    if (j != count1) {
                    System.out.print(array[j] + "a");
                    } else {
                        System.out.println(array[j]);
                    }
                }
            }
        }
    }

}

