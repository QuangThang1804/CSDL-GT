import java.util.Scanner;

public class CardTrick {
  public static void build(int l, int r, int id, int[] tree) {
    if (l == r) {
      tree[id] = 1;
      return;
    }
    int mid = (l + r) / 2;
    build(l, mid, 2 * id, tree);
    build(mid + 1, r, 2 * id + 1, tree);
    tree[id] = tree[2 * id] + tree[2 * id + 1];
  }

  public static int get(int l, int r, int id, int[] tree, int u, int v) {
    if (r < u || v < l || l > r) {
      return 0;
    }

    if (u <= l && r <= v) {
      return tree[id];
    }

    int mid = (l + r) / 2;
    return get(l, mid, 2 * id, tree, u, v) + get(mid + 1, r, 2 * id + 1, tree, u, v);
  }

  public static void update(int l, int r, int id, int[] tree, int i) {
    if (r < i || i < l) {
      return;
    }

    if (l == r) {
      tree[id] = 0;
      return;
    }

    int mid = (l + r) / 2;
    update(l, mid, 2 * id, tree, i);
    update(mid + 1, r, 2 * id + 1, tree, i);
    tree[id] = tree[2 * id] + tree[2 * id + 1];
  }

  public static int getIdOfIthZero(int l, int r, int start, int[] tree, int n, int key) {
    if (l == r) {
      return l;
    }

    int mid = (l + r) / 2;
    int numZero = get(0, n - 1, 1, tree, start, mid);
    if (numZero >= key) {
      return getIdOfIthZero(l, mid, start, tree, n, key);
    } else {
      return getIdOfIthZero(mid + 1, r, start, tree, n, key);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      if (n == 1) {
        System.out.println(1);
        continue;
      }

      int[] tree = new int[4 * n + 1];
      int[] result = new int[n];
      build(0, n - 1, 1, tree);
      update(0, n - 1, 1, tree, 1);
      result[1] = 1;
      int prevId = 1;

      for (int i = 2; i <= n; i++) {
        int numZeroOnRightPrevId = get(0, n - 1, 1, tree, prevId + 1, n - 1);
        int numZeroOnLeftPrevId = get(0, n - 1, 1, tree, 0, prevId - 1);

        int ithZero = i % (numZeroOnRightPrevId + numZeroOnLeftPrevId);
        int id;
        if (ithZero < numZeroOnRightPrevId) {
          id = getIdOfIthZero(prevId + 1, n - 1, prevId + 1, tree, n, ithZero + 1);
        } else {
          ithZero -= numZeroOnRightPrevId;
          id = getIdOfIthZero(0, prevId - 1, 0, tree, n, ithZero + 1);
        }
        result[id] = i;
        update(0, n - 1, 1, tree, id);
        prevId = id;
      }
      for (int i : result) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
}