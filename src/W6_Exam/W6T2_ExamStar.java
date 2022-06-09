package W6_Exam;

public class W6T2_ExamStar {
    public static void main(String[] args) {
        int rows = 25, j = 0, col = 80;
        for (int i = 1; i <= col; i++) {
            System.out.print("_");
        }
        System.out.println();
        for (int i = 1; i <= rows - 1; ++i, j = 0) {
            for (int space = 1; space <= rows + (col/2) - rows - i; ++space) {
                System.out.print("_");
            }

            while (j != (2 * i) - 1) {
                System.out.print("*");
                ++j;
            }

            for (int space = 1; space <= rows + (col/2) - rows - i + 1; ++space) {
                System.out.print("_");
            }
            System.out.println();
        }
    }
}
