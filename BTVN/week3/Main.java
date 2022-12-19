public class Main {
    public static void main(String[] args) {
        int a = 1; 
        boolean [] array = {false, true, true, false,false};
        for (int i = 0; i< array.length; i++) {
            if(!array[i]) {
                a++;
            }
        }
        System.out.println(a);
    }
}