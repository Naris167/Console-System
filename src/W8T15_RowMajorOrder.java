public class W8T15_RowMajorOrder {
    public static void main(String[] args){
        int r = 5;

        // Declaring 2-D array with 5 rows
        int SampleArray[][] = new int[r + 1][];

        // Creating a 2D array such that first row has 1 element
        // second row has two elements and so on.
        for (int i = 1; i < SampleArray.length; i++) {
            SampleArray[i] = new int[i + 1];
        }

        // Start the array
        int count = 1;
        for (int i = 1; i < SampleArray.length; i++) {
            for (int j = 1; j < SampleArray[i].length; j++)
                SampleArray[i][j] = count++;
        }

        // Show values of 2D Jagged array
        System.out.println("Contents of 2D Jagged Array");
        for (int i = 1; i < SampleArray.length; i++) {
            for (int j = 1; j < SampleArray[i].length; j++) {
                System.out.print(SampleArray[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
