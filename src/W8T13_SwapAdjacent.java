public class W8T13_SwapAdjacent {
    public static void main(String[] args) {
        int SampleArray1[] = {10, 20, 30, 40, 50};
        int SampleArray2[] = {10, 20, 30, 40, 50, 60};
        swapPairs(SampleArray1);
        swapPairs(SampleArray2);
    }

    public static void swapPairs(int InputArray[]){
        int elementNumber = InputArray.length - InputArray.length % 2; // if element in array is odd, remove 1
        System.out.print("\n\nArray in original order: "); //Show original array
        for (int i = 0; i < InputArray.length; i++) {
            System.out.print(InputArray[i] + " ");
        }

        System.out.print("\nArray in reverse order: "); //Show array in reverse order
        for(int i = 0; i < elementNumber; i += 2) {
            System.out.print(InputArray[i + 1] + " ");
            System.out.print(InputArray[i] + " ");
        }

        if ((InputArray.length % 2) == 1){ //Print last element when it is odd
            System.out.print(InputArray[InputArray.length - 1]);
        }

    }
}
