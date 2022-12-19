import java.util.*;

public class ABugLife {
  static ArrayList<Integer>[] interactions;
  static int[] sexual;
  static boolean[] visited;
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numScenarios = scanner.nextInt();
    int j = 1;
    while (j <= numScenarios) {
      int numBugs = scanner.nextInt();
      int numInteractions = scanner.nextInt();

      interactions = new ArrayList[numBugs + 1];
      sexual = new int[numBugs + 1];
      visited = new boolean[numBugs + 1];

      for (int i = 1; i <= numBugs; i++) {
        interactions[i] = new ArrayList<>();
      }

      int bug1, bug2;
      while (numInteractions-- > 0) {
        bug1 = scanner.nextInt();
        bug2 = scanner.nextInt();
        interactions[bug1].add(bug2);
        interactions[bug2].add(bug1);
      }

      System.out.println("Scenario #" + j++ + ":");
      if (checkBipartiteGraph()) {
        System.out.println("No suspicious bugs found!");
      } else {
        System.out.println("Suspicious bugs found!");
      }
    }
  }

  public static boolean checkBipartiteGraph() {
    Arrays.fill(sexual, -1);
    Queue<Integer> nextBugs = new LinkedList<>();
    for (int i = 1; i < visited.length; i++) {
      if (visited[i]) {
        continue;
      }
      visited[i] = true;
      sexual[i] = 0;
      nextBugs.add(i);
      while (!nextBugs.isEmpty()) {
        int u = nextBugs.remove();
        for (int otherBug : interactions[u]) {
          if (sexual[otherBug] == sexual[u]) {
            return false;
          }
          if (sexual[otherBug] == -1) {
            sexual[otherBug] = 1 - sexual[u];
            visited[otherBug] = true;
            nextBugs.add(otherBug);
          }
        }
      }
    }
    return true;
  }
}