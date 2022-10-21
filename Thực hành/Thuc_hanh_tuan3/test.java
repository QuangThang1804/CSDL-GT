import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] array = {1, 2, 3, 4, 5};
        int n = array.length;

        int number = 3;

        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        remove(number, array);
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        

        
    }

    public static void remove(int number, int [] array) { 
		
        int n = array.length;
        int index = -1;
        for (int i = 0; i < n; i ++) {
            if (array[i] == number) {
                index = i;
            }
        }

        for (int j = index; j < n - 1; j ++) {
            array[j] = array[j + 1];
        }
	}
}
