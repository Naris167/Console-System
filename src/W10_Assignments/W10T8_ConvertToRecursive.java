package W10_Assignments;

public class W10T8_ConvertToRecursive {
    // Prints each character of the string reversed twice.
    // doubleReverse("hello") prints "oolllleehh"
    public static void main(String[] args) {
        String text = "hello";
        System.out.println("Iterative:");
        System.out.print(text + " to ");
        IterativeDoubleReverse(text);

        System.out.println("\n\nRecursive:");
        System.out.print(text + " to ");
        RecursiveDoubleReverse(text, text.length());

    }

    // Iterative
    public static void IterativeDoubleReverse(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.print(s.charAt(i));
            System.out.print(s.charAt(i));
        }
    }

    // Recursive
    public static void RecursiveDoubleReverse(String str, int i) {
        if(i > 0){
            System.out.print(str.charAt(i-1));
            System.out.print(str.charAt(i-1));
            i--;
            RecursiveDoubleReverse(str,i);
        }
    }
}
