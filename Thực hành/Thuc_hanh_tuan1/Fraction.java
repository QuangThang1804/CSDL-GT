import java.util.StringTokenizer;


// nên tách riêng hiển thị và tính toán
public class Fraction {
    int numerator = 0;
    int denominator = 1;

    public Fraction(String input) {
        StringTokenizer str = new StringTokenizer(input,"/");
        this.numerator = Integer.parseInt(str.nextToken());
        this.denominator = Integer.parseInt(str.nextToken());
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public static String sum(Fraction fraction, Fraction another) {
        int num = 0;
        int deno = 0;
        int deno1 = fraction.getDenominator();
        int deno2 = another.getDenominator();
        int num1 = fraction.getNumerator();
        int num2 = another.getNumerator();
        if (deno1 == deno2) {
            num = num1 + num2;
            deno = deno1;
        } else {
            num = (num1 * deno2) + (num2 * deno1);
            deno = deno1 * deno2;
        }

        return reduce(num, deno);
    }

    public static String min(Fraction fraction, Fraction another) {
        int num = 0;
        int deno = 0;
        int deno1 = fraction.getDenominator();
        int deno2 = another.getDenominator();
        int num1 = fraction.getNumerator();
        int num2 = another.getNumerator();
        if (deno1 == deno2) {
            num = num1 - num2;
            deno = deno1;
        } else {
            num = (num1 * deno2) - (num2 * deno1);
            deno = deno1 * deno2;
        }

        return reduce(num, deno);
    }

    public static String divide(Fraction fraction, Fraction another) {
        int deno1 = fraction.getDenominator();
        int deno2 = another.getDenominator();
        int num1 = fraction.getNumerator();
        int num2 = another.getNumerator();
        int numDiv = num1 * deno2;
        int denoDiv = deno1 * num2;
        return reduce(numDiv, denoDiv);
    }

    public static String pow(Fraction fraction, Fraction another) {
        int deno1 = fraction.getDenominator();
        int deno2 = another.getDenominator();
        int num1 = fraction.getNumerator();
        int num2 = another.getNumerator();
        int numPow = num1 * num2;
        int denoPow = deno1 * deno2;
        return reduce(numPow, denoPow);
    }

    public static String reduce(int num, int deno) {
        int gcd = 0;
        int numTemp = num;
        int denoTemp = deno;
        if (num < 0) numTemp *= -1;
        if (deno < 0) denoTemp *= -1;
        while (gcd != 1) {
            for(int i = 1; i <= numTemp && i <= denoTemp; i++)
            {
                if(num % i == 0 && deno % i == 0)
                    gcd = i;
            }
            num /= gcd;
            deno /=gcd;
        }
        return num + "/" + deno;
    }
}