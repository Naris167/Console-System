package W10_Assignments;

public class W10T3_Power {
    public static void main(String[] args) {
        int power = 2;
        int base = 2;
        int result = pow(base,power);
        System.out.printf("The result of %d power by %d is %d", base, power, result);
    }
    public static int pow(int x, int y) {
        if (y == 0) {
            // base case with y == 0
            return 1;
        } else {
            // recursive case with y > 0
            return x * pow(x, y - 1);
        }
    }
}
