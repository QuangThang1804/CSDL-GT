import java.io.*;
import java.util.*;

import javax.sound.sampled.DataLine;

public class MinimumStocks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // DataInputStream data = new DataInputStream(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer input = new StringTokenizer(br.readLine());
        StringBuilder result = new StringBuilder();

        int n = Integer.parseInt(input.nextToken());
        int lenh;
        String name;
        int value = 0, count = 1;
        int minPrice;
        Map<String, Integer> stockMarket = new HashMap<String, Integer>();
        PriorityQueue<String> price = new PriorityQueue<>((a,b) -> stockMarket.get(a) - stockMarket.get(b));

        while(n-- > 0) {
            input = new StringTokenizer(br.readLine());
            lenh = Integer.parseInt(input.nextToken());
            name = input.nextToken();
            if (lenh != 3) {
                value = Integer.parseInt(input.nextToken());
            }

            switch(lenh) {
                case 1: {
                    stockMarket.put(name, value);
                    price.add(name);
                    break;
                }
                case 2: {
                    stockMarket.replace(name, value);
                    if (!price.isEmpty()) {
                        String finalPriceOfName = name;
                        price.removeIf(p -> p.equals(finalPriceOfName));
                        price.add(finalPriceOfName);
                    }
                    break;
                } 
                case 3: {
                        result.append(price.peek() + " " + count + "\n");
                    break;  
                }
            }
            count++;
        }
        br.close();

        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}
