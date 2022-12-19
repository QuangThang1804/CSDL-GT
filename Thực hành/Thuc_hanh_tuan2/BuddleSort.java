
import java.util.Arrays;
import java.util.Scanner;

public class BuddleSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] array = {5, 7, 4, 3, 10, 22, 65, 34};
        int temp;
        boolean hasSwap;
        int countss = 0, countdc = 0;
        for (int i = 0 ; i < array.length - 1; i++) {
            hasSwap = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                countss++;
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    hasSwap = true;
                    countdc++;
                }
            }
            System.out.println("step " + (i + 1) + ": " + Arrays.toString(array));
            if (hasSwap == false) {
                break;
            }
        }
        System.out.println("So lan so sanh: " + countss);
        System.out.println("So lan doi cho: " + countdc);
    }
}
