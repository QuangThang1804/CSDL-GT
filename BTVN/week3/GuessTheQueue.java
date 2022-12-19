import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class GuessTheQueue {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer in = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int[] id = new int[2000000];
        int numberTests = Integer.parseInt(in.nextToken());
        int bPos;
        int fPos;
        int test = 1;
        while (numberTests-- > 0) {
            map.clear();
            bPos = 100001;
            fPos = 100000;
            result.append("Case ").append(test++).append(":\n");
            in = new StringTokenizer(br.readLine());
            int numberQueries = Integer.parseInt(in.nextToken());
            while (numberQueries-- > 0) {
                in = new StringTokenizer(br.readLine());
                int operator = Integer.parseInt(in.nextToken());
                char c = in.nextToken().charAt(0);
                int newId;
                if (operator == 1) {
                    newId = Integer.parseInt(in.nextToken());
                    if (c == 'B') {
                        map.put(newId, bPos);
                        id[bPos++] = newId;
                    } else {
                        map.put(newId, fPos);
                        id[fPos--] = newId;
                    }
                } else if (operator == 2) {
                    if (c == 'B') {
                        bPos--;
                    } else {
                        fPos++;
                    }
                } else {
                    newId= Integer.parseInt(in.nextToken());
                    if (c == 'D') {
                        result.append(id[fPos + newId]).append("\n");
                    } else {
                        result.append(map.get(newId) - fPos).append("\n");    
                    }
                }
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
