import java.util.*;
import java.io.*;

public class ArrangingAmplifiers2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // bw.write("Nhap so lan test: ");
        // bw.flush();
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            // bw.write("Nhap so bo khuyech dai: ");
            // bw.flush();
            int n = Integer.parseInt(br.readLine());
            String [] in = br.readLine().split(" ");
            int [] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = Integer.valueOf(in[j]);
            }
            Arrays.sort(array);
            
            int count1 = 0;
            for (int j = 0; j < n; j++) {
                if (array[j] == 1) {
                    bw.write(1 + " ");
                    count1++;
                }
            }
            for (int j = n - 1; j >= count1; j--) {
                if (n - count1 == 2 && array[n - 2] == 2 && array[n - 1] == 3) {
                    bw.write(2 + " " + 3 + "\n");
                    break;
                } else {
                    if (j != count1) {
                        bw.write(array[j] + " ");
                    } else {
                        bw.write(String.valueOf(array[j] + "\n"));
                    }
                }
            }
        }
        bw.close();
        br.close();
    }
}