import java.util.*;
import java.io.*;

public class AdaAndQueue2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
        StringTokenizer input = new StringTokenizer(br.readLine());
        Deque<Integer> stack = new ArrayDeque();

        int test = Integer.parseInt(input.nextToken());
        String order ="";
        int number = -1;
        boolean flag = true;
        char firstChar;
        while(test-- > 0) {
            input = new StringTokenizer(br.readLine());
            order = input.nextToken();
            firstChar = order.charAt(0);

            switch(firstChar) {
                case 't': {
                    number = Integer.parseInt(input.nextToken());
                    if (flag) {
                        stack.addFirst(number);
                    } else {
                        stack.addLast(number);
                    }
                    result.append(stack.toString() + "\n");
                    break;
                }
                case 'p': {
                    number = Integer.parseInt(input.nextToken());
                    if (flag) {
                        stack.addLast(number);
                    } else {
                        stack.addFirst(number);
                    } 
                    result.append(stack.toString() + "\n");
                    break;
                }
                case 'f': {
                    if (!flag) {
                        if (stack.isEmpty()) {
                            result.append("No job for Ada?\n");
                        } else {
                            result.append(stack.getLast() + "\n");
                            stack.remove(stack.getLast());
                        }
                        
                    } 
                    else {
                        if (stack.isEmpty()) {
                            result.append("No job for Ada?\n");
                        } else {
                            result.append(stack.pop() + "\n");
                        }
                    } 
                    result.append(stack.toString() + "\n");
                    break;
                }
                case 'b': {
                    if (!flag) {
                        if (stack.isEmpty()) {
                            result.append("No job for Ada?\n");
                        } else {
                            result.append(stack.pop() + "\n");
                        }
                    }else {
                        if (stack.isEmpty()) {
                            result.append("No job for Ada?\n");
                        } else {
                            result.append(stack.getLast() + "\n");
                            stack.remove(stack.getLast());
                        }
                    } 
                    result.append(stack.toString() + "\n");
                    break;
                } 
                default: {
                    flag = !flag;
                }
            }
        }
            
        bw.write(result + "");
        br.close();
        bw.close();
        
    }
}
