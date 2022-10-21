import java.util.Scanner;
import java.util.StringTokenizer;

public class Bai2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringTokenizer phanSo = new StringTokenizer(in.nextLine());
        System.out.print("Tu so 1 la: ");
        int tuSo1 = in.nextInt();
        System.out.print("Mau so 1 la: ");
        int mauSo1 = in.nextInt();
        System.out.println("Phan so 1 la: " + tuSo1 + "/" + mauSo1);

        System.out.print("Tu so 2 la: ");
        int tuSo2 = in.nextInt();
        System.out.print("Mau so 2 la: ");
        int mauSo2 = in.nextInt();
        System.out.println("Phan so 2 la: " + tuSo2 + "/" + mauSo2);

        // Cong, tru, nhan, chia 2 phan so
        add(tuSo1, mauSo1, tuSo2, mauSo2);
        minus(tuSo1, mauSo1, tuSo2, mauSo2);
        multiply(tuSo1, mauSo1, tuSo2, mauSo2);
        divide(tuSo1, mauSo1, tuSo2, mauSo2);
    }

    public static int UCLN(int number1, int number2) {
        while (number1 != number2) {
            if (number1 > number2) {
                number1 -= number2;
            } else {
                number2 -= number1;
            }
        }
        return number1;
    }

    public static void toiGianPhanSo(int tuSo, int mauSo) {
        tuSo /=  UCLN(tuSo, mauSo);
        mauSo /= UCLN(tuSo, mauSo);
         
    }

    public static void add(int tuSo1, int mauSo1, int tuSo2, int mauSo2) {
        int mauSo = mauSo1 * mauSo2;
        int tuSo = (mauSo / mauSo1) * tuSo1 + (mauSo / mauSo2) *tuSo2;
        toiGianPhanSo(tuSo, mauSo);
        System.out.println("Tong 2 phan so la: " + tuSo + "/" + mauSo);
    }

    public static void minus(int tuSo1, int mauSo1, int tuSo2, int mauSo2) {
        int mauSo = mauSo1 * mauSo2;
        int tuSo = (mauSo / mauSo1) * tuSo1 - (mauSo / mauSo2) *tuSo2;
        toiGianPhanSo(tuSo, mauSo);
        System.out.println("Hieu 2 phan so la: " + tuSo + "/" + mauSo);
    }

    public static void multiply(int tuSo1, int mauSo1, int tuSo2, int mauSo2) {
        int mauSo = mauSo1 * mauSo2;
        int tuSo = tuSo1 * tuSo2;
        toiGianPhanSo(tuSo, mauSo);
        System.out.println("Tich 2 phan so la: " + tuSo + "/" + mauSo);
    }

    public static void divide(int tuSo1, int mauSo1, int tuSo2, int mauSo2) {
        int mauSo = mauSo1 * tuSo2;
        int tuSo = tuSo1 * mauSo2;
        toiGianPhanSo(tuSo, mauSo);
        System.out.println("Thuong 2 phan so la: " + tuSo + "/" + mauSo);
    }
}
