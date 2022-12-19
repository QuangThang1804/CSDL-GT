import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;

public class AdaAndSpecies {
  static final int N = 200007;
  static int n;
  static int[] segmentTree = new int[4 * N];
  static int[][] vegetables = new int[N][5];
  static boolean[] isBetter = new boolean[N];
  public static void main(String[] args) {
    n = nextInt();
    Arrays.fill(segmentTree, Integer.MAX_VALUE);
    for (int i = 1; i <= n; i++) {
      vegetables[i][0] = i;
      vegetables[i][1] = nextInt();
      vegetables[i][2] = nextInt();
      vegetables[i][3] = nextInt();
      vegetables[i][4] = nextInt();
    }

    Arrays.sort(vegetables, 1, n + 1, Comparator.comparing(o -> o[1]));
    f(1, n);
    int ans = 0;
    for (int i = 1; i <= n; i++) {
      if (!isBetter[i]) {
        ans++;
      }
    }
    System.out.println(ans);
  }

  public static void update(int id, int left, int right, int i, int value) {
    if (i < left || i > right) {
      return;
    }

    if (left == right) {
      segmentTree[id] = value;
      return;
    }

    int mid = (left + right) / 2;
    update(id * 2, left, mid, i, value);
    update(id * 2 + 1, mid + 1, right, i, value);

    segmentTree[id] = Math.min(segmentTree[id * 2], segmentTree[id * 2 + 1]);
  }

  public static int get(int id, int left, int right, int u, int v) {
    if (v < left || u > right) {
      return Integer.MAX_VALUE;
    }

    if (u <= left && right <= v) {
      return segmentTree[id];
    }

    int mid = (left + right) / 2;
    return Math.min(
            get(id * 2, left, mid, u, v),
            get(id * 2 + 1, mid + 1, right, u, v)
    );
  }

  public static void f(int left, int right) {
    if (left == right) {
      return;
    }

    int mid = (left + right) / 2;
    f(left, mid);
    f(mid + 1, right);
    Arrays.sort(vegetables, left, mid + 1, Comparator.comparing(o -> o[2]));
    Arrays.sort(vegetables, mid + 1, right + 1, Comparator.comparing(o -> o[2]));

    int j = left - 1;

    for (int i = mid + 1; i <= right; i++) {
      while (j <= mid && vegetables[j + 1][2] < vegetables[i][2]) {
        j++;
        update(1, 1, n, vegetables[j][3], vegetables[j][4]);
      }

      if (vegetables[i][3] == 1) {
        continue;
      }

      int x = get(1, 1, n, 1, vegetables[i][3] - 1);

      if (x < vegetables[i][4]) {
        isBetter[vegetables[i][0]] = true;
      }
    }

    j = left - 1;
    for (int i = mid + 1; i <= right; i++) {
      while (j <= mid && vegetables[j + 1][2] < vegetables[i][2]) {
        j++;
        update(1, 1, n, vegetables[j][3], Integer.MAX_VALUE);
      }
    }
  }


  private static final InputStream is = System.in;
  private static final byte[] inBuf = new byte[1024];
  private static int lenBuf = 0;
  private static int ptrBuf = 0;

  private static int readByte() {
    if (lenBuf == -1) throw new InputMismatchException();

    if (ptrBuf >= lenBuf) {
      ptrBuf = 0;
      try {
        lenBuf = is.read(inBuf);
      } catch (IOException e) {
        throw new InputMismatchException();
      }
    }

    if (lenBuf <= 0) return -1;

    return inBuf[ptrBuf++];
  }

  private static int nextInt() {
    int num = 0;
    int b;

    boolean minus = false;
    while ((b = readByte()) != -1 &&
            !((b >= '0' && b <= '9') || b == '-')
    );
    if (b == '-') {
      minus = true;
      b = readByte();
    }

    while (true) {
      if (b >= '0' && b <= '9')
        num = (num << 3) + (num << 1) + (b - '0');
      else
        return minus ? -num : num;
      b = readByte();
    }
  }
}