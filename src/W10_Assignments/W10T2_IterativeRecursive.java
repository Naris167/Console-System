package W10_Assignments;

public class W10T2_IterativeRecursive {
    public static void main(String[] args) {
        IterativeWriteStars(5);
        RecursiveWriteStars(5);
    }

    // Iterative
    public static void IterativeWriteStars(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    // Recursive
    public static void RecursiveWriteStars(int n) {
        if (n == 0) {
            System.out.println();
        } else {
            System.out.print("*");
            RecursiveWriteStars(n - 1);
        }
    }
}
