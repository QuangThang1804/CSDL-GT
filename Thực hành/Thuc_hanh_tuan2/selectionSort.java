import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class selectionSort{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] array = {5, 7, 4, 3, 10, 22, 65, 34};
        int temp;
        int countss = 0, countdc = 0;
        int minIndex = 0;
        // doi cho voi phan tu nho nhat
        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                countss++;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            } 
            if (i != minIndex) {
                temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
                countdc++;
            }
            System.out.println("step " + (i + 1) + ": " + Arrays.toString(array));
        }
        System.out.println("so lan so sanh: " + countss);
        System.out.println("so lan doi cho: " + countdc);
    }
}