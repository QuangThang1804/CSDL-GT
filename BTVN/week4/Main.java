import java.io.*;
import java.util.InputMismatchException;

public class Main {
  private static final InputStream is = System.in;
  private static final byte[] inBuf = new byte[1 << 16];
  private static int lenBuf = 0;
  private static int ptrBuf = 0;

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    MinHeap minHeap = new MinHeap();
    MaxHeap maxHeap = new MaxHeap();

    int t = nextInt();
    int n;
    while (t-- > 0) {
      maxHeap.clear();
      minHeap.clear();
      while (true) {
        n = nextInt();

        if (n == 0) {
          break;
        }

        if (n > 0) {
          if (maxHeap.isEmpty()) {
            maxHeap.add(n);
            continue;
          }

          int minHeapSize = minHeap.size();
          int maxHeapSize = maxHeap.size();
          if (maxHeap.peek() > n) {
            maxHeap.add(n);
            maxHeapSize++;
            if (maxHeapSize == minHeapSize + 2) {
              minHeap.add(maxHeap.poll());
            }
          } else {
            minHeap.add(n);
            minHeapSize++;
            if (maxHeapSize < minHeapSize) {
              maxHeap.add(minHeap.poll());
            }
          }

        } else {
          sb.append(maxHeap.poll()).append("\n");
          if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
          }
        }
      }
    }
    OutputStream os = System.out;
    os.write(sb.toString().getBytes());
    os.close();
  }

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
    while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
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

  //---------------MinHeap & MaxHeap---------------------
  private static class MinHeap {
    private final int[] heap;
    private int size;
    private final int MAX_SIZE = 100000;

    public MinHeap() {
      heap = new int[MAX_SIZE + 1];
      size = 0;
    }

    public void add(int v) {
      heap[++size] = v;
      upHeap();
    }

    public int poll() {
      int max = heap[1];
      heap[1] = heap[size];
      heap[size] = max;
      size--;
      downHeap(1);
      return max;
    }

    public boolean isEmpty() {
      return size == 0;
    }

    public int peek() {
      return heap[1];
    }

    public int size() {
      return size;
    }

    private void upHeap() {
      int index = size;
      while (index > 1 && heap[index >> 1] > heap[index]) {
        int temp = heap[index >> 1];
        heap[index >> 1] = heap[index];
        heap[index] = temp;
        index = index >> 1;
      }
    }

    private void downHeap(int index) {
      while (index << 1 <= size) {
        int nodeId = index << 1;
        if (heap[nodeId] > heap[nodeId + 1] && nodeId < size) {
          nodeId++;
        }
        if (heap[index] < heap[nodeId]) {
          break;
        }
        int temp = heap[nodeId];
        heap[nodeId] = heap[index];
        heap[index] = temp;
        index = nodeId;
      }
    }

    public void clear() {
      size = 0;
    }
  }

  private static class MaxHeap {
    private final int[] heap;
    private int size;
    private final int MAX_SIZE = 100000;

    public MaxHeap() {
      heap = new int[MAX_SIZE + 1];
      size = 0;
    }

    public void add(int v) {
      heap[++size] = v;
      upHeap();
    }

    public int poll() {
      int max = heap[1];
      heap[1] = heap[size];
      heap[size] = max;
      size--;
      downHeap(1);
      return max;
    }

    public boolean isEmpty() {
      return size == 0;
    }

    public int peek() {
      return heap[1];
    }

    public int size() {
      return size;
    }

    private void upHeap() {
      int index = size;
      while (index > 1 && heap[index >> 1] < heap[index]) {
        int temp = heap[index >> 1];
        heap[index >> 1] = heap[index];
        heap[index] = temp;
        index = index >> 1;
      }
    }

    private void downHeap(int index) {
      while (index << 1 <= size) {
        int nodeId = index << 1;
        if (heap[nodeId] < heap[nodeId + 1] && nodeId < size) {
          nodeId++;
        }
        if (heap[index] > heap[nodeId]) {
          break;
        }
        int temp = heap[nodeId];
        heap[nodeId] = heap[index];
        heap[index] = temp;
        index = nodeId;
      }
    }

    public void clear() {
      size = 0;
    }
  }
}