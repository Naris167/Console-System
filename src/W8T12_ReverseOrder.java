public class W8T12_ReverseOrder {
    public static void main(String[] args) {
        //Initialize array
        int SampleArray[] = {4, 3, 6, 8, 2, 44, 221, 222};
        printBackwards(SampleArray);

    }
    public static void printBackwards(int InputArray[]){
        //Show original array
        System.out.print("\nArray in original order: ");
        for (int i = 0; i < InputArray.length; i++) {
            System.out.print(InputArray[i] + " ");
        }

        //Show array in reverse order
        System.out.print("\nArray in reverse order: ");
        for (int i = InputArray.length-1; i >= 0; i--) {
            System.out.print(InputArray[i] + " ");
        }
    }
}
