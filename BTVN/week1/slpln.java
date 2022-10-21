import java.util.Scanner;

public class slpln {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = in.nextInt();
            for (int j = N; j >= 1; j--) {
                if (Math.pow(j, 3)<= N) {
                    System.out.println(j);
                    break;
                } 
            }
        }
    }
}
