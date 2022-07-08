package W10_Assignments;

public class W10T11_StarString2n {
    public static void main(String[] args) {
        System.out.println("starString(0): " + starString(0));
        System.out.println("starString(1): " + starString(1));
        System.out.println("starString(2): " + starString(2));
        System.out.println("starString(3): " + starString(3));
        System.out.println("starString(4): " + starString(4));
    }
    public static String starString(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        } else if (n == 0) {
            return "*";
        } else {
            return starString(n - 1) + starString(n - 1);
        }
    }
}
