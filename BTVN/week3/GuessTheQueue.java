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
        int numberTests = Integer.parseInt(in.nextToken());
        while (numberTests-- > 0) {
            in = new StringTokenizer(br.readLine());
            int numberQueries = Integer.parseInt(in.nextToken());
            while (numberQueries-- > 0) {
                in = new StringTokenizer(br.readLine());
                int operation = Integer.parseInt(in.nextToken());
                char c = in.nextToken().charAt(0);
                int[] id = new int[2000000];
                int newId;
                if (operation == 1) {
                    newId = Integer.parseInt(in.nextToken());
                    if (c == 'B') {
                        map.put(newId);
                        result.append(map.toString());
                    } if (c == 'F') {
                        map.put(0, newId);
                        result.append(map.toString());

                    }
                } else if (operation == 2) {
                    if (c == 'B') {
                        map.remove(map.size());
                    } else {
                        map.remove(0);
                    }
                } else {
                    int positonY = Integer.parseInt(in.nextToken());
                    result.append(map.get(positonY)).append("\n");
                }
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}
