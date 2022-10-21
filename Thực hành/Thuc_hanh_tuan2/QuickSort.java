import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] array = {5, 7, 4, 3, 10, 22, 65, 34};
        int temp;
        int countss = 0, countdc = 0;
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        System.out.println("So lan so sanh: " + countss);
        System.out.println("So lan doi cho: " + countdc);
    }

    public static int index_ngan(int[] array, int low, int high) {
        int chot = array[high];
        int i = low - 1;
        int temp;
        int countss = 0;
        int countdc = 0;
        for (int j = low; j < high; j++) {
            countss++;
            if (array[j] < chot) {
                i++;

                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        countdc++;
        
        return i + 1;
    }

    public static void sort(int [] array, int low, int high) {
        if (low < high) {
            int chot = index_ngan(array, low, high);

            sort(array, 0, chot - 1);
            sort(array, chot + 1, high);
        }
    }
}
