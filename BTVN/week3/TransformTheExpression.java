import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.module.ModuleDescriptor.Builder;
import java.nio.Buffer;

public class TransformTheExpression {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder target = new StringBuilder(); 

        int Test = Integer.parseInt(br.readLine());
        for (int i = 1; i <= Test; i++) {
            
            String s = br.readLine();
            int length = s.length();

            char [] stack = new char[length + 1];
            int size = 0;

            for (int j = 0; j < length; j++) {
                if (isOperand(s.charAt(j))) {
                    target.append(s.charAt(j));
                } else if (s.charAt(j) == '(') {
                    stack[size++] = s.charAt(j);
                } else if (s.charAt(j) == ')') {
                    while (stack[size - 1] != '(') {
                        target.append(stack[size - 1]);
                        size--;
                    }
                    size--;
                } else if (isOperator(s.charAt(j))) {
                    while (isOperator(stack[size - 1]) && getPriority(stack[size - 1]) >= getPriority(s.charAt(j))) {
                        target.append(stack[size - 1]);
                        size--;
                    }

                    stack[size] = s.charAt(j);
                    size++;
                }
            }
            target.append("\n");
        }
        System.out.println(target);
    }

    // Ktra có phải toán hạng ko
    public static boolean isOperand(char ch) {
        return (ch >= 'a' && ch <= 'z');
    }

    //Ktra xem có phải toán tử ko
    public static boolean isOperator(char ch) {
        if (ch == '+' ||ch == '-'|| ch == '*' ||ch == '/' ||ch == '^') {
            return true;
        }
        return false;
    }

    // Trả về độ ưu tiên của các toán tử
    public static int getPriority(char ch) {
        if (ch == '+') return 1;
        else if (ch == '-') return 2;
        else if (ch == '*') return 3;
        else if (ch == '/') return 4;
        else if (ch == '^') return 5;
        else return -1;
    }
}
