public class test {
    public static void main(String[] args) {
        int a = 10, b = 5;
        System.out.println("a = " + a + " b = " + b);

        a = (int) Math.pow(a, b);
        b = (int) Math.pow(a, 1/b);
        a = (int) Math.pow(a, 1/b);
        
        System.out.println("a = " + a + " b = " + b);
    }
}
