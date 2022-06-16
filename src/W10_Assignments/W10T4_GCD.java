package W10_Assignments;

public class W10T4_GCD {
    public static void main(String[] args) {
        int num1 = 132;
        int num2 = 20;
        System.out.printf("The greatest common divisor of %d and %d is %d", num1, num2, gcd(num1,num2));
    }
    public static int gcd(int x, int y) {
        if (y == 0) {
            // base case with y == 0
            return x;
        } else {
            // recursive case with y > 0
            return gcd(y, x % y);
        }
    }
}
