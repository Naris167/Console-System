package W8_Assignments;
// Task 11: Examines an array of integers and reports the maximum value in the array
import java.util.Arrays;

public class W8T11_MaxValue {
    public static void main(String[] args){
        int SampleArray[] = {16, 2620, 435, 190, 2247};
        System.out.println("\nOriginal array: " + Arrays.toString(SampleArray));
        System.out.println("The largest integer given in this array is " + max(SampleArray));
    }

    public static int max(int InputArray[]){
        int maxValue = Arrays.stream(InputArray).max().getAsInt();
        return maxValue;
    }

}
