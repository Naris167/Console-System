import java.util.Random;

public class W5T7_CoinFlip {
    public static void main(String[] args) {
        int tryNum = 0;
        int success = 0;
        while (success < 3) {
            if (new Random().nextBoolean()){
                System.out.print("H ");
                success++;
                tryNum++;
            } else {
                System.out.print("T ");
                success = 0;
                tryNum++;
            }
        }
        System.out.println("\n\nThree heads in a row!");
        System.out.println("I had to flip a coin for " + tryNum + " times ! So tiring!");
    }
}