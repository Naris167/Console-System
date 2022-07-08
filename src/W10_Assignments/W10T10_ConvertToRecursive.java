package W10_Assignments;

public class W10T10_ConvertToRecursive {
    // Returns n!, such as 5! = 1*2*3*4*5
    public static void main(String[] args) {
        int num = 5;
        System.out.println("Iterative:");
        System.out.printf("Factorial of %d is %d", num, IterativeFactorial(num));
        System.out.println("\n\nIterative:");
        System.out.printf("Factorial of %d is %d", num, RecursiveFactorial(num));
    }

    // Iterative
    public static int IterativeFactorial(int n) {
        int product = 1;
        for (int i = 1; i <= n; i++) {
            product *= i;
        }
        return product;
    }

    // Recursive
    public static int RecursiveFactorial(int n) {
        int product = 1;
        if (n >= 1)
            return n * RecursiveFactorial(n - 1);
        else
            return 1;
    }
}
