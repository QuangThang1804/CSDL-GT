import java.io.*;
import java.util.*;

public class AdaAndFriends {
    public static void main(String[] args) throws IOException, java.lang.NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer input = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(input.nextToken());
        int maxFrCanBeMove = Integer.parseInt(input.nextToken());

        String name;
        long value;
        Map<String, Long> friend = new HashMap<String, Long>();
        while(n-- > 0) {
            input = new StringTokenizer(br.readLine());
            name = input.nextToken();
            value = Integer.parseInt(input.nextToken());

            if (friend.containsKey(name)) {
                friend.replace(name, friend.get(name)  + value);
                continue;
            } else {
                friend.put(name, value);
            }
        }

        List<Long> money = new LinkedList<>(friend.values());
        Collections.sort(money);

        long result = 0;    
        maxFrCanBeMove = (maxFrCanBeMove > money.size()) ? money.size() : maxFrCanBeMove;
        while (maxFrCanBeMove-- > 0) {
            // result += money.get(money.size() - maxFrCanBeMove - 1);
            if (money.isEmpty()) {
                break;
            } else {
                result += money.get(money.size() - 1);
                money.remove(money.size() - 1);
            }
        }

        
        bw.write(result + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
