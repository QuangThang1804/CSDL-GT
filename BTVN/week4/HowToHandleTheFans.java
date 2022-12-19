import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class HowToHandleTheFans {
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        int N = nextInt();
        array = new int[N + 1];
        int Q = nextInt();

        String query;
        int A, B;
        while (Q-- > 0) {
            query = next();
            A = nextInt();
            B = nextInt();
            if (query.equals("find")) {
                result.append(getSum(B) - getSum(A - 1));
                result.append("\n");
            } else {
                update(A, B, N);
            }
        }
        bw.write(result + "");
        bw.close();
    }

    public static int getSum(int p) {
        int ans = 0;
        while (p > 0) {
            ans += array[p];
            p -= (p & (-p));
        }
        return ans;
    }

    public static void update(int u, int v, int size) {
    while (u <= size) {
        array[u] += v;
        u += (u & (-u));
    }
}

    static InputStream is = System.in;
    private static final byte[] inBuf = new byte[1024];
    private static int lenBuf = 0;
    private static int ptrBuf = 0;

    public static int readByte() {
        if (lenBuf == -1)
            throw new InputMismatchException();

        if (ptrBuf >= lenBuf) {
            ptrBuf = 0;
            try {
                lenBuf = is.read(inBuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
        }

        if (lenBuf <= 0)
            return -1;

        return inBuf[ptrBuf++];
    }

    public static int nextInt() {
        int num = 0;
        int b;

        boolean minus = false;
        while ((b = readByte()) != -1 &&
                !((b >= '0' && b <= '9') || b == '-'))
            ;
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

    public static String next() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!isSpaceChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    public static boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    public static int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b));
        return b;
    }
}
