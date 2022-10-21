import java.util.Arrays;
import java.util.Scanner;

public class test{
    public static void main(String[] args) {
        int [] array = {2,3,1,4,22,5,3,5,6};
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}