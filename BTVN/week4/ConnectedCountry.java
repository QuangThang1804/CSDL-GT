import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConnectedCountry {
  private static final int BUFFER_SIZE = 1 << 16;
  private static final DataInputStream DATA_INPUT_STREAM = new DataInputStream(System.in);
  private static final byte[] BUFFER = new byte[BUFFER_SIZE];
  static int[] parent;
  static int[] size;
  private static int bufferPointer = 0;
  private static int bytesRead = 0;

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int numCities = sc.nextInt();
    int numRoads = sc.nextInt();

    parent = new int[numCities];
    size = new int[numCities];
    Arrays.setAll(parent, p -> p);
    while (numRoads-- > 0) {
      union(sc.nextInt(), sc.nextInt());
    }

    Set<Integer> s = new HashSet<>();
    for (int i : parent) {
      s.add(find(i));
    }
    // PrintWriter printWriter = new PrintWriter(System.out);
    System.out.println(s.size() - 1);
    // printWriter.println(s.size() - 1);
    // printWriter.close();
  }

  public static int find(int u) {
    return parent[u] == u ? u : (parent[u] = find(parent[u]));
  }

  public static void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a != b) {
      if (size[a] < size[b]) {
        int temp = a;
        a = b;
        b = temp;
      }
      parent[b] = a;
      size[a] += size[b];
    }
  }

  private static int nextInt() throws IOException {
    int ret = 0;
    byte c = read();
    while (c <= ' ') {
      c = read();
    }
    boolean neg = (c == '-');
    if (neg) c = read();
    do {
      ret = ret * 10 + c - '0';
    } while ((c = read()) >= '0' && c <= '9');

    if (neg) return -ret;
    return ret;
  }

  private static void fillBuffer() throws IOException {
    bytesRead = DATA_INPUT_STREAM.read(BUFFER, bufferPointer = 0, BUFFER_SIZE);
    if (bytesRead == -1) BUFFER[0] = -1;
  }

  private static byte read() throws IOException {
    if (bufferPointer == bytesRead) fillBuffer();
    return BUFFER[bufferPointer++];
  }
}