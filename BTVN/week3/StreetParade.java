import java.util.Scanner;

public class StreetParade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        n = sc.nextInt();
        boolean check = false;
        String result = "";
        
        while (n != 0) {
            int size = 0;
            int [] array = new int[n];
            int [] stack = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            
            check = true;
            int start = 1;
            
            for (int j = 0; j < n; j++) {
                while (size > 0 && stack[size - 1] == start) {
                    size--;
                    start++;
                }
    
                if (array[j] == start) {
                    start++;
                } else if (size > 0 && stack[size - 1] < array[j]) {
                    check = false;
                    break;
                } else {
                    stack[size] = array[j];
                    size++;
                }
            }
            n = sc.nextInt();
            result += (check) ? ("yes\n") : ("no\n");
        }
        System.out.println(result);
    }
}