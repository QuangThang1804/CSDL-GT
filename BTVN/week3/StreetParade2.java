import java.util.*;
import java.io.*;

public class StreetParade2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        boolean check = false;
        int size;
        StringBuilder s = new StringBuilder();
        while (n != 0) {
            size = 0;
            String [] in = br.readLine().split(" ");
            int [] array = new int[n];
            int [] stack = new int[n];

            for (int i = 0; i < n; i++) {
                array[i] = Integer.valueOf(in[i]);
            }

            check = true;
            int start = 1;
            for (int i = 0; i < n; i++) {
                while (size > 0 && stack[size - 1] == start) {
                    size--;
                    start++;
                }

                if (array[i] == start) {
                    start++;
                } else if (size > 0 && stack[size - 1] < array[i]) {
                    check = false;
                    break;
                } else {
                    stack[size] = array[i];
                    size++;
                }
            }
            n = Integer.parseInt(br.readLine());
            if (check) {
                s.append("yes\n");
            } else {
                s.append("no\n");
            } 
        }
        bw.write(s.toString());
        br.close();
        bw.close();
    }
}
