import java.io.File;
import java.util.Scanner;

public class acm {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // System.out.print("Nhap so lan muon test: ");
        int T = in.nextInt();
        
        for (int i = 1; i <= T; i++) {
            // System.out.print("Tong ung vien cua mot doi: ");
            int n = in.nextInt();
            // System.out.print("Can nang cua moi ung vien: ");
            int [] weight = new int[n];
            for (int j = 0; j < n; j++) {
                weight[j] = in.nextInt();
            }

            // System.out.print("Nhap nguong can mong muon: ");
            int maxWeight = in.nextInt(); 
            System.out.println(maxWeightTeam(maxWeight, weight));
        }       
    }

    public static int maxWeightTeam(int maxWeight, int[] weight) {
        int sum = 0;
            for (int i = 0; i < weight.length - 2; i++) {
                for (int j = i + 1; j < weight.length - 1; j++) {
                    for (int k = j + 1; k < weight.length; k++) {
                        if (sum < weight[i] + weight[j] + weight[k] &&  weight[i] + weight[j] + weight[k] <= maxWeight) {
                            sum = weight[i] + weight[j] + weight[k];
                        }
                    }
                }
            }
        return sum;
    }
}
