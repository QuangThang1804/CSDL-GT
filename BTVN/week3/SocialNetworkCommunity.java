import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SocialNetworkCommunity {
  static int numberUsers;
  static int maxSize;
  static int [] community;
  static int [] size; 
  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder result = new StringBuilder();
    StringTokenizer in = new StringTokenizer(br.readLine());
    numberUsers = Integer.parseInt(in.nextToken());
    maxSize = Integer.parseInt(in.nextToken());
    in = new StringTokenizer(br.readLine());
    int numberQueries = Integer.parseInt(in.nextToken());
    community = new int[numberUsers];
    size = new int[numberUsers];
    for (int i = 0; i < numberUsers; i++) {
      community[i] = i;
      size[i] = 1;
    }
    // community = {0, 1, 2, 3, 4}
    // size = {1, 1, 1, 1, 1}
    while (numberQueries-- > 0) {
      in = new StringTokenizer(br.readLine());
      char c = in.nextToken().charAt(0);
      int user1 = Integer.parseInt(in.nextToken()) - 1;
      
      if (c == 'A') {
        int user2 = Integer.parseInt(in.nextToken()) - 1;
        setCommunity(user1, user2);
      } else if (c == 'E') {
        int user2 = Integer.parseInt(in.nextToken()) - 1;
        result.append( (find(user1) == find(user2)) ? "Yes\n" : "No\n");
        // bw.write(result + "");
        // bw.flush();
      } else {
        result.append(size[find(user1)]).append("\n");
        // bw.write(result + "");
        // bw.flush();
      }
    }
    bw.write(result + "");
    br.close();
    bw.close();

  }

  public static int find(int user) {
    while (user != community[user]) {
      community[user] = community[community[user]];
      user = community[user];
    }
    return user;
  }

  public static void setCommunity(int user1, int user2) {
     int communityOfUser1 = find(user1);
     int communityOfUser2 = find(user2);
     if (communityOfUser1 != communityOfUser2 & size[communityOfUser1] + size[communityOfUser2] <= maxSize) {
      if (size[communityOfUser1] < size[communityOfUser2]) {
        int tmp = size[communityOfUser1];
        size[communityOfUser1] = size[communityOfUser2];
        size[communityOfUser2] = tmp;
      } 
      community[communityOfUser1] = communityOfUser2;
      size[communityOfUser2] += size[communityOfUser1];
    }
  }
}