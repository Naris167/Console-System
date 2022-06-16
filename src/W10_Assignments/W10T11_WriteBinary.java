package W10_Assignments;

public class W10T11_WriteBinary {
    public static void main(String[] args) {
        System.out.print("\nThe result of writeBinary(44) is ");
        writeBinary(44);
    }

    public static void writeBinary(int n) {
        if(n < 2) {
            System.out.print(n);
        } else {
            writeBinary(n / 2);
            writeBinary(n % 2);
        }
    }
}
