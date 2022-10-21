import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SocialNetworkCommunity {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder target = new StringBuilder();

        String [] s = br.readLine().split(" ");
        int numberPeople = Integer.valueOf(s[0]);
        int max = Integer.valueOf(s[1]);
        int q = Integer.parseInt(br.readLine());

        System.out.println(numberPeople + " " + max + " " + q);

        for (int i = 1; i <= q; i++) {
            String [] strQueries = br.readLine().split(" ");
            if (strQueries[0] == "S") {

            } else if (strQueries[0] == "A") {

            } else if (strQueries[0] == "E") {

            }
        }
    }

    public static int numberOfFriend(int people) {
        int numberOfFriend = 1;
        
        return numberOfFriend;
    }

    // public static boolean isFriend() {
        
    // }
}
