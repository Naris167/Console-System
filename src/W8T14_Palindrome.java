import java.util.Arrays;

public class W8T14_Palindrome {
    public static void main(String[] args) {
        String SampleArray1[] = {"alpha", "beta", "gamma", "delta", "gamma", "beta", "alpha"};
        String SampleArray2[] = {"alpha", "gamma", "beta", "delta", "gamma", "alpha", "beta"};
        System.out.println("\nOriginal array: " + Arrays.toString(SampleArray1));
        System.out.println("Is this array considered to be palindrome?\nAnswer: " + isPalindrome(SampleArray1));
        System.out.println("\nOriginal array: " + Arrays.toString(SampleArray2));
        System.out.println("Is this array considered to be palindrome?\nAnswer: " + isPalindrome(SampleArray2));
    }
    public static boolean isPalindrome(String InputArray[]){
        for (int i=0;i<InputArray.length;i++){
            if (!InputArray[i].equals(InputArray[InputArray.length - i - 1]))
                return false;
        }
        return true;
    }
    }
